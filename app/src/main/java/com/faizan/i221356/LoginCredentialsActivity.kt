package com.faizan.i221356

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class LoginCredentialsActivity : AppCompatActivity() {
    private var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_credentials)

        val usernameInput: EditText = findViewById(R.id.usernameInput)
        val passwordInput: EditText = findViewById(R.id.passwordInput)
        val passwordToggle: ImageView = findViewById(R.id.passwordToggle)
        val loginButton: CardView = findViewById(R.id.loginButton)
        val signupLink: TextView = findViewById(R.id.signupLink)
        val forgotPasswordLink: TextView = findViewById(R.id.forgotPasswordLink)

        // Password toggle functionality
        passwordToggle.setOnClickListener {
            isPasswordVisible = !isPasswordVisible
            if (isPasswordVisible) {
                passwordInput.transformationMethod = HideReturnsTransformationMethod.getInstance()
                passwordToggle.setImageResource(android.R.drawable.ic_menu_view)
            } else {
                passwordInput.transformationMethod = PasswordTransformationMethod.getInstance()
                passwordToggle.setImageResource(android.R.drawable.ic_menu_view)
            }
        }

        // Login button functionality
        loginButton.setOnClickListener {
            val username = usernameInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            if (username.isEmpty()) {
                Toast.makeText(this, "Please enter username", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Simple validation - accept any non-empty username and password for demo
            if (username.isNotEmpty() && password.isNotEmpty()) {
                Log.d("LoginCredentials", "Login successful, navigating to FeedActivity")
                Toast.makeText(this, "Login successful! Welcome $username", Toast.LENGTH_SHORT).show()
                // Navigate to main feed screen
                try {
                    val intent = Intent(this, FeedActivity::class.java)
                    startActivity(intent)
                    finish()
                } catch (e: Exception) {
                    Log.e("LoginCredentials", "Error starting FeedActivity", e)
                    Toast.makeText(this, "Error opening feed page", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }

        // Forgot password functionality
        forgotPasswordLink.setOnClickListener {
            Toast.makeText(this, "Forgot password feature coming soon!", Toast.LENGTH_SHORT).show()
        }

        // Set up navigation to signup page
        signupLink.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }
}
