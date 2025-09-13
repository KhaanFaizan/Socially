package com.faizan.i221356

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MessagesActivity : AppCompatActivity() {
    
    override fun onStart() {
        super.onStart()
        Log.d("MessagesActivity", "onStart called")
    }
    
    override fun onResume() {
        super.onResume()
        Log.d("MessagesActivity", "onResume called")
        Toast.makeText(this, "MessagesActivity is now visible!", Toast.LENGTH_LONG).show()
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MessagesActivity", "onCreate called - starting MessagesActivity")
        
        try {
            setContentView(R.layout.activity_messages)
            Log.d("MessagesActivity", "Layout set successfully")
        } catch (e: Exception) {
            Log.e("MessagesActivity", "Error setting content view: ${e.message}")
            Toast.makeText(this, "Error loading messages layout: ${e.message}", Toast.LENGTH_LONG).show()
            return
        }

        Log.d("MessagesActivity", "MessagesActivity created successfully")
        Toast.makeText(this, "Welcome to Messages!", Toast.LENGTH_SHORT).show()

        // Set up click listeners for interactive elements
        setupClickListeners()
        
        // Debug: Check if layout elements are found
        val backArrow = findViewById<ImageView>(R.id.backArrow)
        val plusIcon = findViewById<ImageView>(R.id.plusIcon)
        val cameraButton = findViewById<LinearLayout>(R.id.cameraButton)
        
        Log.d("MessagesActivity", "backArrow found: ${backArrow != null}")
        Log.d("MessagesActivity", "plusIcon found: ${plusIcon != null}")
        Log.d("MessagesActivity", "cameraButton found: ${cameraButton != null}")
    }

    private fun setupClickListeners() {
        // Back arrow navigation
        val backArrow: ImageView = findViewById(R.id.backArrow)
        if (backArrow != null) {
            backArrow.setOnClickListener {
                Toast.makeText(this, "Back arrow clicked!", Toast.LENGTH_SHORT).show()
                try {
                    finish()
                    Log.d("MessagesActivity", "Returning to previous page")
                } catch (e: Exception) {
                    Log.e("MessagesActivity", "Error going back: ${e.message}")
                    Toast.makeText(this, "Error going back: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        } else {
            Log.e("MessagesActivity", "Back arrow not found!")
            Toast.makeText(this, "Back arrow not found!", Toast.LENGTH_SHORT).show()
        }

        // Plus icon
        val plusIcon: ImageView = findViewById(R.id.plusIcon)
        if (plusIcon != null) {
            plusIcon.setOnClickListener {
                Toast.makeText(this, "Plus icon clicked!", Toast.LENGTH_SHORT).show()
                Toast.makeText(this, "New message feature coming soon!", Toast.LENGTH_SHORT).show()
            }
        } else {
            Log.e("MessagesActivity", "Plus icon not found!")
            Toast.makeText(this, "Plus icon not found!", Toast.LENGTH_SHORT).show()
        }

        // Camera button
        val cameraButton: LinearLayout = findViewById(R.id.cameraButton)
        if (cameraButton != null) {
            cameraButton.setOnClickListener {
                Toast.makeText(this, "Camera button clicked!", Toast.LENGTH_SHORT).show()
                Toast.makeText(this, "Camera feature coming soon!", Toast.LENGTH_SHORT).show()
            }
        } else {
            Log.e("MessagesActivity", "Camera button not found!")
            Toast.makeText(this, "Camera button not found!", Toast.LENGTH_SHORT).show()
        }
    }
}
