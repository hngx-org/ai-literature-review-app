package com.example.literaturereview.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.literaturereview.databinding.FragmentOnBoarding2Binding

class OnBoarding2Fragment : Fragment() {

    lateinit var binding: FragmentOnBoarding2Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentOnBoarding2Binding.inflate(inflater,container,false)
        return binding.root
    }

}