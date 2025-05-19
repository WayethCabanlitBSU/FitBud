package com.example.fitbud

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.fitbud.utils.PrefsManager

class BMICalculatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        // Theme check
        if (PrefsManager.isDarkMode(this)) {
            setTheme(R.style.Theme_FitBud_Dark)
        } else {
            setTheme(R.style.Theme_FitBud)
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi_calculator)

        val toolbar = findViewById<Toolbar>(R.id.bmiToolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val inputHeight = findViewById<EditText>(R.id.inputHeight)
        val inputWeight = findViewById<EditText>(R.id.inputWeight)
        val resultText = findViewById<TextView>(R.id.txtBMIResult)
        val calcBtn = findViewById<Button>(R.id.btnCalculateBMI)

        calcBtn.setOnClickListener {
            val heightStr = inputHeight.text.toString()
            val weightStr = inputWeight.text.toString()

            if (heightStr.isBlank() || weightStr.isBlank()) {
                Toast.makeText(this, "Please enter height and weight", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val height = heightStr.toFloat() / 100  // convert cm to meters
            val weight = weightStr.toFloat()

            val bmi = weight / (height * height)
            val category = when {
                bmi < 18.5 -> "Underweight"
                bmi < 24.9 -> "Normal"
                bmi < 29.9 -> "Overweight"
                else -> "Obese"
            }

            resultText.text = "BMI: %.1f (%s)".format(bmi, category)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
