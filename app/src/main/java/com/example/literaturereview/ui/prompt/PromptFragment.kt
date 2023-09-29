package com.example.literaturereview.ui.prompt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.literaturereview.databinding.CompletionListBinding
import com.example.literaturereview.databinding.FragmentPromptBinding


class PromptFragment : Fragment() {

    private var _binding : FragmentPromptBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView : RecyclerView
    private lateinit var adapter: MyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPromptBinding.inflate(layoutInflater, container, false)

        recyclerView = binding.rvCompletionList
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)


        // Todo : Do something with this button



        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}