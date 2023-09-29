package com.example.literaturereview.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.literaturereview.adapter.ViewPagerAdapter
import com.example.literaturereview.R
import com.example.literaturereview.databinding.FragmentOnBoardingScreenBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class OnBoardingScreen : Fragment() {

    private lateinit var binding: FragmentOnBoardingScreenBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = FragmentOnBoardingScreenBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

            val adapter = ViewPagerAdapter(this@OnBoardingScreen)
            val tabLayout = binding.tabIndicator
            viewPager2.adapter = adapter
            showActiveFragment(tabLayout,viewPager2)

            //signup btn
            btnSignUp.setOnClickListener {
                findNavController().navigate(R.id.signUpFragment)
            }

                // login btn
                btnLogin.setOnClickListener {
                findNavController().navigate(R.id.loginFragment)
            }
        }
    }

    private fun showActiveFragment(tabLayout: TabLayout, viewPager2: ViewPager2){
        TabLayoutMediator(tabLayout, viewPager2) { tab, positon ->
            when (positon) {
                0 -> {
                    tab.setIcon(R.drawable.active_background)
                }
                1 -> {
                    tab.setIcon(R.drawable.active_background)
                }
                2 -> {
                    tab.setIcon(R.drawable.active_background)
                }
            }
        }.attach()
    }


}