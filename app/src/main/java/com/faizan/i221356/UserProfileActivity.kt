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

class UserProfileActivity : AppCompatActivity() {
    
    private var isFollowing = false
    
    private lateinit var backButton: ImageView
    private lateinit var usernameText: TextView
    private lateinit var verifiedIcon: ImageView
    private lateinit var moreOptionsButton: ImageView
    private lateinit var profileImage: ImageView
    private lateinit var postsCountText: TextView
    private lateinit var followersCountText: TextView
    private lateinit var followingCountText: TextView
    private lateinit var fullNameText: TextView
    private lateinit var usernameTagText: TextView
    private lateinit var bioText: TextView
    private lateinit var websiteText: TextView
    private lateinit var followButton: LinearLayout
    private lateinit var followButtonText: TextView
    private lateinit var messageButton: LinearLayout
    private lateinit var emailButton: LinearLayout
    private lateinit var addButton: ImageView
    private lateinit var gridTabButton: ImageView
    private lateinit var taggedTabButton: ImageView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)
        
        Log.d("UserProfileActivity", "User profile opened")
        
        // Initialize views
        initializeViews()
        
        // Set up click listeners
        setupClickListeners()
        
        // Load profile data
        loadProfileData()
    }
    
    private fun initializeViews() {
        backButton = findViewById(R.id.backButton)
        usernameText = findViewById(R.id.usernameText)
        verifiedIcon = findViewById(R.id.verifiedIcon)
        moreOptionsButton = findViewById(R.id.moreOptionsButton)
        profileImage = findViewById(R.id.profileImage)
        postsCountText = findViewById(R.id.postsCountText)
        followersCountText = findViewById(R.id.followersCountText)
        followingCountText = findViewById(R.id.followingCountText)
        fullNameText = findViewById(R.id.fullNameText)
        usernameTagText = findViewById(R.id.usernameTagText)
        bioText = findViewById(R.id.bioText)
        websiteText = findViewById(R.id.websiteText)
        followButton = findViewById(R.id.followButton)
        followButtonText = findViewById(R.id.followButtonText)
        messageButton = findViewById(R.id.messageButton)
        emailButton = findViewById(R.id.emailButton)
        addButton = findViewById(R.id.addButton)
        gridTabButton = findViewById(R.id.gridTabButton)
        taggedTabButton = findViewById(R.id.taggedTabButton)
    }
    
    private fun setupClickListeners() {
        // Back button
        backButton.setOnClickListener {
            Log.d("UserProfileActivity", "Back button clicked")
            finish()
        }
        
        // More options button
        moreOptionsButton.setOnClickListener {
            Toast.makeText(this, "More options", Toast.LENGTH_SHORT).show()
            Log.d("UserProfileActivity", "More options clicked")
        }
        
        // Action buttons
        followButton.setOnClickListener {
            toggleFollowStatus()
        }
        
        messageButton.setOnClickListener {
            Toast.makeText(this, "Send message", Toast.LENGTH_SHORT).show()
            Log.d("UserProfileActivity", "Message button clicked")
        }
        
        emailButton.setOnClickListener {
            Toast.makeText(this, "Send email", Toast.LENGTH_SHORT).show()
            Log.d("UserProfileActivity", "Email button clicked")
        }
        
        addButton.setOnClickListener {
            Toast.makeText(this, "Add user", Toast.LENGTH_SHORT).show()
            Log.d("UserProfileActivity", "Add button clicked")
        }
        
        // Tab buttons
        gridTabButton.setOnClickListener {
            Toast.makeText(this, "Posts grid view", Toast.LENGTH_SHORT).show()
            Log.d("UserProfileActivity", "Grid tab clicked")
        }
        
        taggedTabButton.setOnClickListener {
            Toast.makeText(this, "Tagged photos view", Toast.LENGTH_SHORT).show()
            Log.d("UserProfileActivity", "Tagged tab clicked")
        }
    }
    
    private fun loadProfileData() {
        // Get profile data from intent
        val username = intent.getStringExtra("username") ?: "kyan.coleman"
        val fullName = intent.getStringExtra("fullName") ?: "Kyan Coleman"
        val bio = intent.getStringExtra("bio") ?: "Blogger\nAt vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecat... more"
        val website = intent.getStringExtra("website") ?: "kyan.co"
        val postsCount = intent.getIntExtra("postsCount", 151)
        val followersCount = intent.getIntExtra("followersCount", 112000)
        val followingCount = intent.getIntExtra("followingCount", 162)
        
        // Set profile data
        usernameText.text = username
        fullNameText.text = fullName
        usernameTagText.text = "@$username"
        bioText.text = bio
        websiteText.text = website
        postsCountText.text = postsCount.toString()
        followersCountText.text = formatNumber(followersCount)
        followingCountText.text = followingCount.toString()
        
        Log.d("UserProfileActivity", "Loaded profile for user: $username")
    }
    
    private fun formatNumber(number: Int): String {
        return when {
            number >= 1000000 -> "${number / 1000000}M"
            number >= 1000 -> "${number / 1000}K"
            else -> number.toString()
        }
    }
    
    private fun toggleFollowStatus() {
        isFollowing = !isFollowing
        
        if (isFollowing) {
            followButtonText.text = "Following"
            followButton.background = getDrawable(R.drawable.action_button_background)
            followButtonText.setTextColor(getColor(android.R.color.black))
            Toast.makeText(this, "You are now following this user", Toast.LENGTH_SHORT).show()
            Log.d("UserProfileActivity", "User followed")
        } else {
            followButtonText.text = "Follow"
            followButton.background = getDrawable(R.drawable.follow_button_background)
            followButtonText.setTextColor(getColor(android.R.color.white))
            Toast.makeText(this, "You unfollowed this user", Toast.LENGTH_SHORT).show()
            Log.d("UserProfileActivity", "User unfollowed")
        }
    }
    
    override fun onBackPressed() {
        super.onBackPressed()
        Log.d("UserProfileActivity", "Back pressed - closing user profile")
    }
}
