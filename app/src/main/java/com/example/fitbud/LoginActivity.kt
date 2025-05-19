package com.example.fitbud

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fitbud.utils.PrefsManager

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        if (PrefsManager.isDarkMode(this)) setTheme(R.style.Theme_FitBud_Dark)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val email = findViewById<EditText>(R.id.editEmail)
        val password = findViewById<EditText>(R.id.editPassword)

        findViewById<Button>(R.id.btnLogin).setOnClickListener {
            if (email.text.toString() == PrefsManager.getEmail(this) &&
                password.text.toString() == PrefsManager.getPassword(this)
            ) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Invalid login", Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<TextView>(R.id.txtSignup).setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }
    }
}
