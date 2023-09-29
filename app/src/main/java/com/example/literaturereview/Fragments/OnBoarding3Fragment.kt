package com.example.literaturereview.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.literaturereview.R
import com.example.literaturereview.databinding.FragmentOnBoarding3Binding

class OnBoarding3Fragment : Fragment() {

    lateinit var binding: FragmentOnBoarding3Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
      binding = FragmentOnBoarding3Binding.inflate(inflater,container,false)
        return binding.root
    }


}