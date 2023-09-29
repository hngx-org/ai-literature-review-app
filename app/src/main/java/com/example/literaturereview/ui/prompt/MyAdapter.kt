package com.example.literaturereview.ui.prompt

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.literaturereview.databinding.CompletionListBinding
import com.example.literaturereview.models.GenerationResult

class MyAdapter(private val _context : Context) : ListAdapter<GenerationResult, MyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CompletionListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {

        // Todo - When I come back. Continue this.
    }

    override fun onBindViewHolder(holder: MyAdapter, position: Int) {

    }

    inner class ViewHolder(private val binding : CompletionListBinding) : ViewHolder(binding.root) {

    }


}