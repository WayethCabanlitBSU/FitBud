package com.example.fitbud

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.fitbud.utils.PrefsManager

class WorkoutTimerActivity : AppCompatActivity() {

    private var timer: CountDownTimer? = null
    private var isRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        if (PrefsManager.isDarkMode(this)) {
            setTheme(R.style.Theme_FitBud_Dark)
        } else {
            setTheme(R.style.Theme_FitBud)
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_timer)

        val toolbar = findViewById<Toolbar>(R.id.timerToolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val timerText = findViewById<TextView>(R.id.txtTimer)
        val btnStart = findViewById<Button>(R.id.btnStartTimer)
        val btnStop = findViewById<Button>(R.id.btnStopTimer)

        btnStart.setOnClickListener {
            if (!isRunning) {
                startTimer(timerText)
                isRunning = true
            }
        }

        btnStop.setOnClickListener {
            timer?.cancel()
            timerText.text = "30 sec"
            isRunning = false
        }
    }

    private fun startTimer(timerText: TextView) {
        timer = object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timerText.text = "${millisUntilFinished / 1000} sec"
            }

            override fun onFinish() {
                timerText.text = "Workout Complete! 💪"
                isRunning = false
            }
        }.start()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
