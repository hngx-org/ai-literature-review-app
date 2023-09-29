package com.example.literaturereview.ui.prompt

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.literaturereview.databinding.CompletionListBinding
import com.example.literaturereview.models.GenerationResult

class MyAdapter : ListAdapter<GenerationResult, MyAdapter.MyViewHolder>(DiffCallBack) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = CompletionListBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    inner class MyViewHolder(private val binding : CompletionListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(result : GenerationResult) {
            binding.apply {
                tVUserPrompt.text = result.prompt
                tvCompletion.text = result.completion
            }
        }
    }

    object DiffCallBack : DiffUtil.ItemCallback<GenerationResult>() {
        override fun areItemsTheSame(oldItem: GenerationResult, newItem: GenerationResult): Boolean =
            oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: GenerationResult, newItem: GenerationResult): Boolean =
            oldItem == newItem
        }
}