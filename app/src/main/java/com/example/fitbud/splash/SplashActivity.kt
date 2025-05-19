package com.example.fitbud.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AlphaAnimation
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.fitbud.LoginActivity
import com.example.fitbud.R
import com.example.fitbud.utils.PrefsManager

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        if (PrefsManager.isDarkMode(this)) {
            setTheme(R.style.Theme_FitBud_Dark)
        } else {
            setTheme(R.style.Theme_FitBud)
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val splashImage = findViewById<ImageView>(R.id.logoImage)

        // Apply fade-in animation
        val fadeIn = AlphaAnimation(0f, 1f).apply {
            duration = 1000
            fillAfter = true
        }
        splashImage.startAnimation(fadeIn)

        // Delay navigation to Login
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }, 2000)
    }
}
