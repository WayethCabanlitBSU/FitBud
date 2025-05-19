package com.example.fitbud

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fitbud.utils.PrefsManager

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        if (PrefsManager.isDarkMode(this)) setTheme(R.style.Theme_FitBud_Dark)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val email = findViewById<EditText>(R.id.editEmailSignup)
        val password = findViewById<EditText>(R.id.editPasswordSignup)

        findViewById<Button>(R.id.btnCreateAccount).setOnClickListener {
            PrefsManager.saveUser(this, email.text.toString(), password.text.toString())
            Toast.makeText(this, "Account Created!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}
