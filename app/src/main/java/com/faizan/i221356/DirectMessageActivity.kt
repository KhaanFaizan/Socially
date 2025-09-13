package com.faizan.i221356

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DirectMessageActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("DirectMessageActivity", "onCreate called - starting DirectMessageActivity")
        
        try {
            setContentView(R.layout.activity_direct_message)
            Log.d("DirectMessageActivity", "Layout set successfully")
        } catch (e: Exception) {
            Log.e("DirectMessageActivity", "Error setting content view: ${e.message}")
            Toast.makeText(this, "Error loading DM layout: ${e.message}", Toast.LENGTH_LONG).show()
            return
        }

        Log.d("DirectMessageActivity", "DirectMessageActivity created successfully")
        Toast.makeText(this, "Direct Message with ahmad_khan", Toast.LENGTH_SHORT).show()

        // Set up click listeners for interactive elements
        setupClickListeners()
        
        // Debug: Check if layout elements are found
        val backArrow = findViewById<ImageView>(R.id.backArrow)
        val videoCallIcon = findViewById<ImageView>(R.id.videoCallIcon)
        val infoIcon = findViewById<ImageView>(R.id.infoIcon)
        val cameraIcon = findViewById<ImageView>(R.id.cameraIcon)
        val messageInput = findViewById<TextView>(R.id.messageInput)
        val micIcon = findViewById<ImageView>(R.id.micIcon)
        val galleryIcon = findViewById<ImageView>(R.id.galleryIcon)
        val emojiIcon = findViewById<ImageView>(R.id.emojiIcon)
        
        Log.d("DirectMessageActivity", "backArrow found: ${backArrow != null}")
        Log.d("DirectMessageActivity", "videoCallIcon found: ${videoCallIcon != null}")
        Log.d("DirectMessageActivity", "infoIcon found: ${infoIcon != null}")
        Log.d("DirectMessageActivity", "cameraIcon found: ${cameraIcon != null}")
        Log.d("DirectMessageActivity", "messageInput found: ${messageInput != null}")
    }

    private fun setupClickListeners() {
        // Back arrow navigation
        val backArrow: ImageView = findViewById(R.id.backArrow)
        if (backArrow != null) {
            backArrow.setOnClickListener {
                Toast.makeText(this, "Back arrow clicked!", Toast.LENGTH_SHORT).show()
                try {
                    finish()
                    Log.d("DirectMessageActivity", "Returning to previous page")
                } catch (e: Exception) {
                    Log.e("DirectMessageActivity", "Error going back: ${e.message}")
                    Toast.makeText(this, "Error going back: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        } else {
            Log.e("DirectMessageActivity", "Back arrow not found!")
            Toast.makeText(this, "Back arrow not found!", Toast.LENGTH_SHORT).show()
        }

        // Video call icon
        val videoCallIcon: ImageView = findViewById(R.id.videoCallIcon)
        if (videoCallIcon != null) {
            videoCallIcon.setOnClickListener {
                Toast.makeText(this, "Video call feature coming soon!", Toast.LENGTH_SHORT).show()
            }
        } else {
            Log.e("DirectMessageActivity", "Video call icon not found!")
        }

        // Info icon
        val infoIcon: ImageView = findViewById(R.id.infoIcon)
        if (infoIcon != null) {
            infoIcon.setOnClickListener {
                Toast.makeText(this, "Contact info feature coming soon!", Toast.LENGTH_SHORT).show()
            }
        } else {
            Log.e("DirectMessageActivity", "Info icon not found!")
        }

        // Camera icon in input bar
        val cameraIcon: ImageView = findViewById(R.id.cameraIcon)
        if (cameraIcon != null) {
            cameraIcon.setOnClickListener {
                Toast.makeText(this, "Camera feature coming soon!", Toast.LENGTH_SHORT).show()
            }
        } else {
            Log.e("DirectMessageActivity", "Camera icon not found!")
        }

        // Message input click
        val messageInput: TextView = findViewById(R.id.messageInput)
        if (messageInput != null) {
            messageInput.setOnClickListener {
                Toast.makeText(this, "Message input clicked!", Toast.LENGTH_SHORT).show()
            }
        } else {
            Log.e("DirectMessageActivity", "Message input not found!")
        }

        // Microphone icon
        val micIcon: ImageView = findViewById(R.id.micIcon)
        if (micIcon != null) {
            micIcon.setOnClickListener {
                Toast.makeText(this, "Voice message feature coming soon!", Toast.LENGTH_SHORT).show()
            }
        } else {
            Log.e("DirectMessageActivity", "Mic icon not found!")
        }

        // Gallery icon
        val galleryIcon: ImageView = findViewById(R.id.galleryIcon)
        if (galleryIcon != null) {
            galleryIcon.setOnClickListener {
                Toast.makeText(this, "Gallery feature coming soon!", Toast.LENGTH_SHORT).show()
            }
        } else {
            Log.e("DirectMessageActivity", "Gallery icon not found!")
        }

        // Emoji icon
        val emojiIcon: ImageView = findViewById(R.id.emojiIcon)
        if (emojiIcon != null) {
            emojiIcon.setOnClickListener {
                Toast.makeText(this, "Emoji picker feature coming soon!", Toast.LENGTH_SHORT).show()
            }
        } else {
            Log.e("DirectMessageActivity", "Emoji icon not found!")
        }
    }
}
