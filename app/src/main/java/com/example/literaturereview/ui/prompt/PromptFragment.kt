package com.example.literaturereview.ui.prompt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.literaturereview.R
import com.example.literaturereview.databinding.FragmentPromptBinding
import com.example.literaturereview.models.GenerationResult

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

        // Todo - When I come back tomorrow, I will continue working on the redesign of the fragment_prompt.xml

        adapter = MyAdapter()
        recyclerView = binding.rvCompletionList
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)

        val customList = listOf(
            GenerationResult(prompt = "First Example Prompt", completion = getString(R.string.lorem_ipsum)),
            GenerationResult(prompt = "Second Example Prompt", completion = getString(R.string.lorem_ipsum2)),
            GenerationResult(prompt = "Third Example Prompt", completion = getString(R.string.lorem_ipsum)),
            GenerationResult(prompt = "Fourth Example Prompt", completion = getString(R.string.lorem_ipsum2))
        )
        adapter.submitList(customList)

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}