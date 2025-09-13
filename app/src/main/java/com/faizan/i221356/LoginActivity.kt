package com.faizan.i221356

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginButton: CardView = findViewById(R.id.loginButton)
        val signupLink: TextView = findViewById(R.id.signupLink)

        // Login button functionality - navigate to credentials page
        loginButton.setOnClickListener {
            val intent = Intent(this, LoginCredentialsActivity::class.java)
            startActivity(intent)
        }

        // Set up navigation to signup page
        signupLink.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }
}
