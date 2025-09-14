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

class SharedStoryActivity : AppCompatActivity() {
    
    private lateinit var closeButton: ImageView
    private lateinit var profileImage: ImageView
    private lateinit var usernameText: TextView
    private lateinit var verifiedIcon: ImageView
    private lateinit var timeText: TextView
    private lateinit var storyImageView: ImageView
    private lateinit var likeButton: ImageView
    private lateinit var activityButton: LinearLayout
    private lateinit var createButton: LinearLayout
    private lateinit var facebookButton: LinearLayout
    private lateinit var highlightButton: LinearLayout
    private lateinit var moreButton: LinearLayout
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_story)
        
        Log.d("SharedStoryActivity", "Shared story viewer opened")
        
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
        verifiedIcon = findViewById(R.id.verifiedIcon)
        timeText = findViewById(R.id.timeText)
        storyImageView = findViewById(R.id.storyImageView)
        likeButton = findViewById(R.id.likeButton)
        activityButton = findViewById(R.id.activityButton)
        createButton = findViewById(R.id.createButton)
        facebookButton = findViewById(R.id.facebookButton)
        highlightButton = findViewById(R.id.highlightButton)
        moreButton = findViewById(R.id.moreButton)
    }
    
    private fun setupClickListeners() {
        // Close button
        closeButton.setOnClickListener {
            Log.d("SharedStoryActivity", "Close button clicked")
            finish()
        }
        
        // Like button
        likeButton.setOnClickListener {
            Toast.makeText(this, "Story liked!", Toast.LENGTH_SHORT).show()
            Log.d("SharedStoryActivity", "Like button clicked")
        }
        
        // Bottom navigation
        activityButton.setOnClickListener {
            Toast.makeText(this, "Activity", Toast.LENGTH_SHORT).show()
            Log.d("SharedStoryActivity", "Activity button clicked")
        }
        
        createButton.setOnClickListener {
            Toast.makeText(this, "Create", Toast.LENGTH_SHORT).show()
            Log.d("SharedStoryActivity", "Create button clicked")
        }
        
        facebookButton.setOnClickListener {
            Toast.makeText(this, "Facebook", Toast.LENGTH_SHORT).show()
            Log.d("SharedStoryActivity", "Facebook button clicked")
        }
        
        highlightButton.setOnClickListener {
            Toast.makeText(this, "Highlight", Toast.LENGTH_SHORT).show()
            Log.d("SharedStoryActivity", "Highlight button clicked")
        }
        
        moreButton.setOnClickListener {
            Toast.makeText(this, "More", Toast.LENGTH_SHORT).show()
            Log.d("SharedStoryActivity", "More button clicked")
        }
    }
    
    private fun loadStoryData() {
        // Get story data from intent
        val username = intent.getStringExtra("username") ?: "gursky.studio"
        val timeAgo = intent.getStringExtra("timeAgo") ?: "11h"
        val storyImage = intent.getIntExtra("storyImage", R.drawable.shutterstock_100407100)
        
        // Set story data
        usernameText.text = username
        timeText.text = timeAgo
        storyImageView.setImageResource(storyImage)
        
        Log.d("SharedStoryActivity", "Loaded shared story for user: $username")
    }
    
    override fun onBackPressed() {
        super.onBackPressed()
        Log.d("SharedStoryActivity", "Back pressed - closing shared story")
    }
}
