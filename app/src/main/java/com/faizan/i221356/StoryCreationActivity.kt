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

class StoryCreationActivity : AppCompatActivity() {
    
    private lateinit var closeButton: ImageView
    private lateinit var stickerButton: ImageView
    private lateinit var textButton: ImageView
    private lateinit var filterButton: ImageView
    private lateinit var musicButton: ImageView
    private lateinit var magicButton: ImageView
    private lateinit var moreOptionsButton: ImageView
    private lateinit var yourStoriesButton: LinearLayout
    private lateinit var closeFriendsButton: LinearLayout
    private lateinit var shareButton: ImageView
    private lateinit var storyImageView: ImageView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story_creation)
        
        Log.d("StoryCreationActivity", "Story creation screen opened")
        
        // Initialize views
        initializeViews()
        
        // Set up click listeners
        setupClickListeners()
    }
    
    private fun initializeViews() {
        closeButton = findViewById(R.id.closeButton)
        stickerButton = findViewById(R.id.stickerButton)
        textButton = findViewById(R.id.textButton)
        filterButton = findViewById(R.id.filterButton)
        musicButton = findViewById(R.id.musicButton)
        magicButton = findViewById(R.id.magicButton)
        moreOptionsButton = findViewById(R.id.moreOptionsButton)
        yourStoriesButton = findViewById(R.id.yourStoriesButton)
        closeFriendsButton = findViewById(R.id.closeFriendsButton)
        shareButton = findViewById(R.id.shareButton)
        storyImageView = findViewById(R.id.storyImageView)
    }
    
    private fun setupClickListeners() {
        // Close button
        closeButton.setOnClickListener {
            Log.d("StoryCreationActivity", "Close button clicked")
            finish()
        }
        
        // Editing tools
        stickerButton.setOnClickListener {
            Toast.makeText(this, "Stickers", Toast.LENGTH_SHORT).show()
            Log.d("StoryCreationActivity", "Sticker button clicked")
        }
        
        textButton.setOnClickListener {
            Toast.makeText(this, "Add Text", Toast.LENGTH_SHORT).show()
            Log.d("StoryCreationActivity", "Text button clicked")
        }
        
        filterButton.setOnClickListener {
            Toast.makeText(this, "Filters", Toast.LENGTH_SHORT).show()
            Log.d("StoryCreationActivity", "Filter button clicked")
        }
        
        musicButton.setOnClickListener {
            Toast.makeText(this, "Add Music", Toast.LENGTH_SHORT).show()
            Log.d("StoryCreationActivity", "Music button clicked")
        }
        
        magicButton.setOnClickListener {
            Toast.makeText(this, "Magic Tools", Toast.LENGTH_SHORT).show()
            Log.d("StoryCreationActivity", "Magic button clicked")
        }
        
        moreOptionsButton.setOnClickListener {
            Toast.makeText(this, "More Options", Toast.LENGTH_SHORT).show()
            Log.d("StoryCreationActivity", "More options clicked")
        }
        
        // Sharing options
        yourStoriesButton.setOnClickListener {
            Toast.makeText(this, "Share to Your Stories", Toast.LENGTH_SHORT).show()
            Log.d("StoryCreationActivity", "Your stories button clicked")
        }
        
        closeFriendsButton.setOnClickListener {
            Toast.makeText(this, "Share to Close Friends", Toast.LENGTH_SHORT).show()
            Log.d("StoryCreationActivity", "Close friends button clicked")
        }
        
        shareButton.setOnClickListener {
            Toast.makeText(this, "Sharing story...", Toast.LENGTH_SHORT).show()
            try {
                val intent = Intent(this, SharedStoryActivity::class.java)
                intent.putExtra("username", "gursky.studio")
                intent.putExtra("timeAgo", "now")
                intent.putExtra("storyImage", R.drawable.shutterstock_100407100)
                startActivity(intent)
                Log.d("StoryCreationActivity", "Navigating to SharedStoryActivity")
            } catch (e: Exception) {
                Log.e("StoryCreationActivity", "Error navigating to SharedStoryActivity: ${e.message}")
                Toast.makeText(this, "Error sharing story: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }
    
    override fun onBackPressed() {
        super.onBackPressed()
        Log.d("StoryCreationActivity", "Back pressed - closing story creation")
    }
}
