package com.example.literaturereview.ui.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import com.example.literaturereview.MainActivity
import com.example.literaturereview.R
import com.example.literaturereview.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {

    lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            val slideanimation = AnimationUtils.loadAnimation(this@SplashScreen, R.anim.splash_screen_animation)

            AppNameTV.startAnimation(slideanimation)

            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this@SplashScreen,MainActivity::class.java))
                finish()
            },4000)



        }

    }





}

