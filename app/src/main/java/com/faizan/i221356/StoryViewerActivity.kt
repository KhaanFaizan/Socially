package com.faizan.i221356

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class StoryViewerActivity : AppCompatActivity() {
    
    private lateinit var closeButton: ImageView
    private lateinit var profileImage: ImageView
    private lateinit var usernameText: TextView
    private lateinit var timeText: TextView
    private lateinit var storyImageView: ImageView
    private lateinit var sendMessageLayout: LinearLayout
    private lateinit var messageInput: TextView
    private lateinit var sendButton: ImageView
    private lateinit var moreOptionsButton: ImageView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story_viewer)
        
        Log.d("StoryViewerActivity", "Story viewer opened")
        
        // Initialize views
        initializeViews()
        
        // Set up click listeners
        setupClickListeners()
        
        // Load story data
        loadStoryData()
    }
    
    private fun initializeViews() {
        closeButton = findViewById(R.id.closeButton)
        profileImage = findViewById(R.id.profileImage)
        usernameText = findViewById(R.id.usernameText)
        timeText = findViewById(R.id.timeText)
        storyImageView = findViewById(R.id.storyImageView)
        sendMessageLayout = findViewById(R.id.sendMessageLayout)
        messageInput = findViewById(R.id.messageInput)
        sendButton = findViewById(R.id.sendButton)
        moreOptionsButton = findViewById(R.id.moreOptionsButton)
    }
    
    private fun setupClickListeners() {
        // Close button
        closeButton.setOnClickListener {
            Log.d("StoryViewerActivity", "Close button clicked")
            finish()
        }
        
        // Send message layout
        sendMessageLayout.setOnClickListener {
            Toast.makeText(this, "Message input clicked", Toast.LENGTH_SHORT).show()
            Log.d("StoryViewerActivity", "Message input clicked")
        }
        
        // Send button
        sendButton.setOnClickListener {
            Toast.makeText(this, "Send message", Toast.LENGTH_SHORT).show()
            Log.d("StoryViewerActivity", "Send button clicked")
        }
        
        // More options button
        moreOptionsButton.setOnClickListener {
            Toast.makeText(this, "More options", Toast.LENGTH_SHORT).show()
            Log.d("StoryViewerActivity", "More options clicked")
        }
        
        // Story image tap to go to next story
        storyImageView.setOnClickListener {
            Toast.makeText(this, "Next story", Toast.LENGTH_SHORT).show()
            Log.d("StoryViewerActivity", "Story image tapped - next story")
        }
    }
    
    private fun loadStoryData() {
        // Get story data from intent
        val username = intent.getStringExtra("username") ?: "craig_love"
        val timeAgo = intent.getStringExtra("timeAgo") ?: "1h"
        val storyImage = intent.getIntExtra("storyImage", R.drawable.shutterstock_100407100)
        
        // Set story data
        usernameText.text = username
        timeText.text = timeAgo
        storyImageView.setImageResource(storyImage)
        
        Log.d("StoryViewerActivity", "Loaded story for user: $username")
    }
    
    override fun onBackPressed() {
        super.onBackPressed()
        Log.d("StoryViewerActivity", "Back pressed - closing story viewer")
    }
}
