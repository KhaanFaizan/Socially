package com.faizan.i221356

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class SignupActivity : AppCompatActivity() {
    private var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val usernameInput: EditText = findViewById(R.id.usernameInput)
        val nameInput: EditText = findViewById(R.id.nameInput)
        val lastNameInput: EditText = findViewById(R.id.lastNameInput)
        val dobInput: EditText = findViewById(R.id.dobInput)
        val emailInput: EditText = findViewById(R.id.emailInput)
        val passwordInput: EditText = findViewById(R.id.passwordInput)
        val passwordToggle: ImageView = findViewById(R.id.passwordToggle)
        val createAccountButton: CardView = findViewById(R.id.createAccountButton)

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

        // Create Account button functionality
        createAccountButton.setOnClickListener {
            val username = usernameInput.text.toString().trim()
            val name = nameInput.text.toString().trim()
            val lastName = lastNameInput.text.toString().trim()
            val dob = dobInput.text.toString().trim()
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            // Form validation
            if (username.isEmpty()) {
                Toast.makeText(this, "Please enter username", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (name.isEmpty()) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (lastName.isEmpty()) {
                Toast.makeText(this, "Please enter your last name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (dob.isEmpty()) {
                Toast.makeText(this, "Please enter date of birth", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (email.isEmpty()) {
                Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password.length < 6) {
                Toast.makeText(this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Simple email validation
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Please enter a valid email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // If all validations pass
            Toast.makeText(this, "Account created successfully!", Toast.LENGTH_SHORT).show()
            
            // Navigate back to login page
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
