package com.example.fitbud

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.fitbud.utils.PrefsManager

class WorkoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // Apply dark/light theme first
        if (PrefsManager.isDarkMode(this)) {
            setTheme(R.style.Theme_FitBud_Dark)
        } else {
            setTheme(R.style.Theme_FitBud)
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout)

        // 🔙 Set up toolbar
        val toolbar = findViewById<Toolbar>(R.id.workoutToolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val txtWorkout = findViewById<TextView>(R.id.txtWorkout)
        val imgWorkout = findViewById<ImageView>(R.id.imgWorkout)

        findViewById<Button>(R.id.btnHappy).setOnClickListener {
            txtWorkout.text = "Jump around or do a dance workout!"
            imgWorkout.setImageResource(R.drawable.happy_workout)
        }

        findViewById<Button>(R.id.btnTired).setOnClickListener {
            txtWorkout.text = "Try gentle yoga or a stretching session."
            imgWorkout.setImageResource(R.drawable.tired_workout)
        }

        findViewById<Button>(R.id.btnStressed).setOnClickListener {
            txtWorkout.text = "Deep breathing, meditation or light walking."
            imgWorkout.setImageResource(R.drawable.stressed_workout)
        }

        findViewById<Button>(R.id.btnEnergetic).setOnClickListener {
            txtWorkout.text = "Perfect time for HIIT or a 10-min run!"
            imgWorkout.setImageResource(R.drawable.energetic_workout)
        }
    }
    // Handle back arrow press
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
