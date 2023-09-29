package com.example.literaturereview.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.literaturereview.databinding.FragmentOnBoarding3Binding

class OnBoarding3Fragment : Fragment() {

    private lateinit var binding: FragmentOnBoarding3Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentOnBoarding3Binding.inflate(inflater, container, false)
        return binding.root
    }


}