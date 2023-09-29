package com.example.literaturereview.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.literaturereview.Fragments.OnBoarding1Fragment
import com.example.literaturereview.Fragments.OnBoarding2Fragment
import com.example.literaturereview.Fragments.OnBoarding3Fragment


class ViewPagerAdapter(fa: Fragment): FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return  when (position){
            0 -> OnBoarding1Fragment()
            1 -> OnBoarding2Fragment()
            2 -> OnBoarding3Fragment()
            else -> OnBoarding1Fragment()
        }
    }
}
