package com.faizan.i221356

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EditProfileActivity : AppCompatActivity() {
    
    private lateinit var nameEditText: EditText
    private lateinit var usernameEditText: EditText
    private lateinit var websiteEditText: EditText
    private lateinit var bioEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var genderEditText: EditText
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("EditProfileActivity", "onCreate called - starting EditProfileActivity")
        
        try {
            setContentView(R.layout.activity_edit_profile)
            Log.d("EditProfileActivity", "Layout set successfully")
        } catch (e: Exception) {
            Log.e("EditProfileActivity", "Error setting content view: ${e.message}")
            Toast.makeText(this, "Error loading edit profile layout: ${e.message}", Toast.LENGTH_LONG).show()
            return
        }

        Log.d("EditProfileActivity", "EditProfileActivity created successfully")
        Toast.makeText(this, "Edit Profile", Toast.LENGTH_SHORT).show()

        // Initialize form fields
        initializeFormFields()
        
        // Set up click listeners
        setupClickListeners()
        
        // Load current profile data
        loadProfileData()
    }
    
    private fun initializeFormFields() {
        nameEditText = findViewById(R.id.nameEditText)
        usernameEditText = findViewById(R.id.usernameEditText)
        websiteEditText = findViewById(R.id.websiteEditText)
        bioEditText = findViewById(R.id.bioEditText)
        emailEditText = findViewById(R.id.emailEditText)
        phoneEditText = findViewById(R.id.phoneEditText)
        genderEditText = findViewById(R.id.genderEditText)
        
        Log.d("EditProfileActivity", "Form fields initialized")
    }
    
    private fun setupClickListeners() {
        // Cancel button
        val cancelButton: TextView = findViewById(R.id.cancelButton)
        if (cancelButton != null) {
            cancelButton.setOnClickListener {
                finish()
                Log.d("EditProfileActivity", "Cancelled editing profile")
            }
        } else {
            Log.e("EditProfileActivity", "Cancel button not found!")
        }
        
        // Done button
        val doneButton: TextView = findViewById(R.id.doneButton)
        if (doneButton != null) {
            doneButton.setOnClickListener {
                saveProfile()
            }
        } else {
            Log.e("EditProfileActivity", "Done button not found!")
        }
        
        // Change Profile Photo
        val changePhotoText: TextView = findViewById(R.id.changePhotoText)
        if (changePhotoText != null) {
            changePhotoText.setOnClickListener {
                Toast.makeText(this, "Change profile photo feature coming soon!", Toast.LENGTH_SHORT).show()
            }
        } else {
            Log.e("EditProfileActivity", "Change photo text not found!")
        }
        
        // Switch to Professional Account
        val switchAccountText: TextView = findViewById(R.id.switchAccountText)
        if (switchAccountText != null) {
            switchAccountText.setOnClickListener {
                Toast.makeText(this, "Switch to Professional Account feature coming soon!", Toast.LENGTH_SHORT).show()
            }
        } else {
            Log.e("EditProfileActivity", "Switch account text not found!")
        }
    }
    
    private fun loadProfileData() {
        // Load current profile data into form fields
        nameEditText.setText("Jacob West")
        usernameEditText.setText("jacob_w")
        websiteEditText.setText("")
        bioEditText.setText("Digital goodies designer @pixsellz\nEverything is designed.")
        emailEditText.setText("jacob.west@gmail.com")
        phoneEditText.setText("+1 202 555 0147")
        genderEditText.setText("Male")
        
        Log.d("EditProfileActivity", "Profile data loaded into form")
    }
    
    private fun saveProfile() {
        // Validate form fields
        if (validateForm()) {
            // Get form data
            val name = nameEditText.text.toString().trim()
            val username = usernameEditText.text.toString().trim()
            val website = websiteEditText.text.toString().trim()
            val bio = bioEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val phone = phoneEditText.text.toString().trim()
            val gender = genderEditText.text.toString().trim()
            
            // Save profile data (in a real app, this would save to database/API)
            Log.d("EditProfileActivity", "Profile saved:")
            Log.d("EditProfileActivity", "Name: $name")
            Log.d("EditProfileActivity", "Username: $username")
            Log.d("EditProfileActivity", "Website: $website")
            Log.d("EditProfileActivity", "Bio: $bio")
            Log.d("EditProfileActivity", "Email: $email")
            Log.d("EditProfileActivity", "Phone: $phone")
            Log.d("EditProfileActivity", "Gender: $gender")
            
            Toast.makeText(this, "Profile updated successfully!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
    
    private fun validateForm(): Boolean {
        var isValid = true
        
        // Validate name
        if (nameEditText.text.toString().trim().isEmpty()) {
            nameEditText.error = "Name is required"
            isValid = false
        }
        
        // Validate username
        if (usernameEditText.text.toString().trim().isEmpty()) {
            usernameEditText.error = "Username is required"
            isValid = false
        }
        
        // Validate email
        val email = emailEditText.text.toString().trim()
        if (email.isEmpty()) {
            emailEditText.error = "Email is required"
            isValid = false
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.error = "Please enter a valid email"
            isValid = false
        }
        
        // Validate phone
        if (phoneEditText.text.toString().trim().isEmpty()) {
            phoneEditText.error = "Phone is required"
            isValid = false
        }
        
        // Validate gender
        if (genderEditText.text.toString().trim().isEmpty()) {
            genderEditText.error = "Gender is required"
            isValid = false
        }
        
        if (!isValid) {
            Toast.makeText(this, "Please fill in all required fields correctly", Toast.LENGTH_LONG).show()
        }
        
        return isValid
    }
}
