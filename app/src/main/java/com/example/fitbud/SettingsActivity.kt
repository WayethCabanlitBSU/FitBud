package com.example.fitbud

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import androidx.appcompat.widget.Toolbar
import com.example.fitbud.utils.PrefsManager

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // Apply dark or light theme
        if (PrefsManager.isDarkMode(this)) {
            setTheme(R.style.Theme_FitBud_Dark)
        } else {
            setTheme(R.style.Theme_FitBud)
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // Setup toolbar with back arrow
        val toolbar = findViewById<Toolbar>(R.id.settingsToolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Setup dark mode switch
        val switchDarkMode = findViewById<SwitchCompat>(R.id.switchDarkMode)
        switchDarkMode.isChecked = PrefsManager.isDarkMode(this)

        switchDarkMode.setOnCheckedChangeListener { _, isChecked ->
            PrefsManager.saveDarkMode(this, isChecked)
            recreate() // Reload with new theme
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
