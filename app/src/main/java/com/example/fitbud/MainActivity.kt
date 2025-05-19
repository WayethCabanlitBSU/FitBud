package com.example.fitbud

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.fitbud.utils.PrefsManager

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        if (PrefsManager.isDarkMode(this)) setTheme(R.style.Theme_FitBud_Dark)
        else setTheme(R.style.Theme_FitBud)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val workoutBtn = findViewById<Button>(R.id.btnWorkout)
        val settingsBtn = findViewById<Button>(R.id.btnSettings)

        workoutBtn.setOnClickListener {
            val intent = Intent(this, WorkoutActivity::class.java)
            startActivity(intent)
        }

        settingsBtn.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnBmiCalculator).setOnClickListener {
            startActivity(Intent(this, BMICalculatorActivity::class.java))
        }

        findViewById<Button>(R.id.btnWorkoutTimer).setOnClickListener {
            startActivity(Intent(this, WorkoutTimerActivity::class.java))
        }


    }
}


