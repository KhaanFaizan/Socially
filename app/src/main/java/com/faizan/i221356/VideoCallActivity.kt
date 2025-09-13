package com.faizan.i221356

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class VideoCallActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("VideoCallActivity", "onCreate called - starting VideoCallActivity")
        
        try {
            setContentView(R.layout.activity_video_call)
            Log.d("VideoCallActivity", "Layout set successfully")
        } catch (e: Exception) {
            Log.e("VideoCallActivity", "Error setting content view: ${e.message}")
            Toast.makeText(this, "Error loading video call layout: ${e.message}", Toast.LENGTH_LONG).show()
            return
        }

        Log.d("VideoCallActivity", "VideoCallActivity created successfully")
        Toast.makeText(this, "Video call with Mother", Toast.LENGTH_SHORT).show()

        // Set up click listeners for interactive elements
        setupClickListeners()
        
        // Debug: Check if layout elements are found
        val menuIcon = findViewById<ImageView>(R.id.menuIcon)
        val endCallButton = findViewById<ImageView>(R.id.endCallButton)
        val speakerIcon = findViewById<ImageView>(R.id.speakerIcon)
        val contactName = findViewById<TextView>(R.id.contactName)
        val callDuration = findViewById<TextView>(R.id.callDuration)
        
        Log.d("VideoCallActivity", "menuIcon found: ${menuIcon != null}")
        Log.d("VideoCallActivity", "endCallButton found: ${endCallButton != null}")
        Log.d("VideoCallActivity", "speakerIcon found: ${speakerIcon != null}")
        Log.d("VideoCallActivity", "contactName found: ${contactName != null}")
        Log.d("VideoCallActivity", "callDuration found: ${callDuration != null}")
    }

    private fun setupClickListeners() {
        // Menu icon
        val menuIcon: ImageView = findViewById(R.id.menuIcon)
        if (menuIcon != null) {
            menuIcon.setOnClickListener {
                Toast.makeText(this, "Menu clicked!", Toast.LENGTH_SHORT).show()
                Toast.makeText(this, "Call options coming soon!", Toast.LENGTH_SHORT).show()
            }
        } else {
            Log.e("VideoCallActivity", "Menu icon not found!")
            Toast.makeText(this, "Menu icon not found!", Toast.LENGTH_SHORT).show()
        }

        // End call button
        val endCallButton: ImageView = findViewById(R.id.endCallButton)
        if (endCallButton != null) {
            endCallButton.setOnClickListener {
                Toast.makeText(this, "End call clicked!", Toast.LENGTH_SHORT).show()
                try {
                    finish()
                    Log.d("VideoCallActivity", "Ending video call and returning to previous page")
                } catch (e: Exception) {
                    Log.e("VideoCallActivity", "Error ending call: ${e.message}")
                    Toast.makeText(this, "Error ending call: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        } else {
            Log.e("VideoCallActivity", "End call button not found!")
            Toast.makeText(this, "End call button not found!", Toast.LENGTH_SHORT).show()
        }

        // Speaker icon
        val speakerIcon: ImageView = findViewById(R.id.speakerIcon)
        if (speakerIcon != null) {
            speakerIcon.setOnClickListener {
                Toast.makeText(this, "Speaker clicked!", Toast.LENGTH_SHORT).show()
                Toast.makeText(this, "Speaker toggle feature coming soon!", Toast.LENGTH_SHORT).show()
            }
        } else {
            Log.e("VideoCallActivity", "Speaker icon not found!")
            Toast.makeText(this, "Speaker icon not found!", Toast.LENGTH_SHORT).show()
        }
    }
}
