package com.faizan.i221356

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FeedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)
        
        Log.d("FeedActivity", "FeedActivity created successfully")
        Log.d("FeedActivity", "Layout loaded: ${findViewById<LinearLayout>(R.id.headerLayout) != null}")
        Toast.makeText(this, "Welcome to Socially Feed!", Toast.LENGTH_LONG).show()

        // Set up click listeners for interactive elements
        setupClickListeners()
    }

    private fun setupClickListeners() {
        // Camera icon in header
        val cameraIcon: ImageView = findViewById(R.id.cameraIcon)
        cameraIcon.setOnClickListener {
            Toast.makeText(this, "Opening camera!", Toast.LENGTH_SHORT).show()
            try {
                val intent = Intent(this, CameraActivity::class.java)
                startActivity(intent)
                Log.d("FeedActivity", "Navigating to CameraActivity")
            } catch (e: Exception) {
                Log.e("FeedActivity", "Error navigating to CameraActivity: ${e.message}")
                Toast.makeText(this, "Error opening camera: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }

        // Your Story section
        val yourStoryLayout: LinearLayout = findViewById(R.id.yourStoryLayout)
        yourStoryLayout.setOnClickListener {
            Toast.makeText(this, "Opening camera for your story!", Toast.LENGTH_SHORT).show()
            try {
                val intent = Intent(this, CameraActivity::class.java)
                startActivity(intent)
                Log.d("FeedActivity", "Navigating to CameraActivity from Your Story")
            } catch (e: Exception) {
                Log.e("FeedActivity", "Error navigating to CameraActivity from Your Story: ${e.message}")
                Toast.makeText(this, "Error opening camera: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }

        // Reels icon in header
        val reelsIcon: ImageView = findViewById(R.id.reelsIcon)
        reelsIcon.setOnClickListener {
            Toast.makeText(this, "Reels feature coming soon!", Toast.LENGTH_SHORT).show()
        }

        // Messages icon in header
        val messagesIcon: ImageView = findViewById(R.id.messagesIcon)
        if (messagesIcon != null) {
            messagesIcon.setOnClickListener {
                Toast.makeText(this, "Messages icon clicked!", Toast.LENGTH_SHORT).show()
                try {
                    Log.d("FeedActivity", "Creating Intent for MessagesActivity")
                    val intent = Intent(this, MessagesActivity::class.java)
                    Log.d("FeedActivity", "Starting MessagesActivity")
                    startActivity(intent)
                    Log.d("FeedActivity", "Successfully started MessagesActivity")
                } catch (e: Exception) {
                    Log.e("FeedActivity", "Error navigating to MessagesActivity: ${e.message}")
                    Toast.makeText(this, "Error opening messages: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        } else {
            Log.e("FeedActivity", "Messages icon not found!")
            Toast.makeText(this, "Messages icon not found!", Toast.LENGTH_SHORT).show()
        }

        // Story click listeners
        setupStoryClickListeners()

        // Bottom navigation items
        val homeIcon: ImageView = findViewById(R.id.homeIcon)
        homeIcon.setOnClickListener {
            Toast.makeText(this, "Home - Already here!", Toast.LENGTH_SHORT).show()
        }

        val searchBottomIcon: ImageView = findViewById(R.id.searchBottomIcon)
        if (searchBottomIcon != null) {
            searchBottomIcon.setOnClickListener {
                Toast.makeText(this, "Search icon clicked!", Toast.LENGTH_SHORT).show()
                try {
                    val intent = Intent(this, SearchActivity::class.java)
                    startActivity(intent)
                    Log.d("FeedActivity", "Navigating to SearchActivity from bottom nav")
                } catch (e: Exception) {
                    Log.e("FeedActivity", "Error navigating to SearchActivity: ${e.message}")
                    Toast.makeText(this, "Error opening search page: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        } else {
            Log.e("FeedActivity", "Search icon not found!")
            Toast.makeText(this, "Search icon not found!", Toast.LENGTH_SHORT).show()
        }

        val addPostIcon: ImageView = findViewById(R.id.addPostIcon)
        addPostIcon.setOnClickListener {
            Toast.makeText(this, "Opening upload content!", Toast.LENGTH_SHORT).show()
            try {
                val intent = Intent(this, UploadContentActivity::class.java)
                startActivity(intent)
                Log.d("FeedActivity", "Navigating to UploadContentActivity")
            } catch (e: Exception) {
                Log.e("FeedActivity", "Error navigating to UploadContentActivity: ${e.message}")
                Toast.makeText(this, "Error opening upload page: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }

        val activityIcon: ImageView = findViewById(R.id.activityIcon)
        if (activityIcon != null) {
            activityIcon.setOnClickListener {
                Toast.makeText(this, "Activity icon clicked!", Toast.LENGTH_SHORT).show()
                try {
                    val intent = Intent(this, ActivityNotificationActivity::class.java)
                    startActivity(intent)
                    Log.d("FeedActivity", "Navigating to ActivityNotificationActivity")
                } catch (e: Exception) {
                    Log.e("FeedActivity", "Error navigating to ActivityNotificationActivity: ${e.message}")
                    Toast.makeText(this, "Error opening activity page: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        } else {
            Log.e("FeedActivity", "Activity icon not found!")
            Toast.makeText(this, "Activity icon not found!", Toast.LENGTH_SHORT).show()
        }

        val profileIcon: ImageView = findViewById(R.id.profileIcon)
        if (profileIcon != null) {
            profileIcon.setOnClickListener {
                Toast.makeText(this, "Profile icon clicked!", Toast.LENGTH_SHORT).show()
                try {
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    Log.d("FeedActivity", "Navigating to ProfileActivity")
                } catch (e: Exception) {
                    Log.e("FeedActivity", "Error navigating to ProfileActivity: ${e.message}")
                    Toast.makeText(this, "Error opening profile page: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        } else {
            Log.e("FeedActivity", "Profile icon not found!")
            Toast.makeText(this, "Profile icon not found!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupStoryClickListeners() {
        // Story 1 - karennne
        val story1Layout: LinearLayout = findViewById(R.id.story1Layout)
        story1Layout.setOnClickListener {
            openStoryViewer("karennne", "2h", R.drawable.shutterstock_1011776404)
        }

        // Story 2 - zackjohn
        val story2Layout: LinearLayout = findViewById(R.id.story2Layout)
        story2Layout.setOnClickListener {
            openStoryViewer("zackjohn", "4h", R.drawable.shutterstock_1033038292)
        }

        // Story 3 - kieron_d
        val story3Layout: LinearLayout = findViewById(R.id.story3Layout)
        story3Layout.setOnClickListener {
            openStoryViewer("kieron_d", "6h", R.drawable.shutterstock_1068919502)
        }
    }

    private fun openStoryViewer(username: String, timeAgo: String, storyImage: Int) {
        Toast.makeText(this, "Opening story from $username", Toast.LENGTH_SHORT).show()
        try {
            val intent = Intent(this, StoryViewerActivity::class.java)
            intent.putExtra("username", username)
            intent.putExtra("timeAgo", timeAgo)
            intent.putExtra("storyImage", storyImage)
            startActivity(intent)
            Log.d("FeedActivity", "Navigating to StoryViewerActivity for $username")
        } catch (e: Exception) {
            Log.e("FeedActivity", "Error navigating to StoryViewerActivity: ${e.message}")
            Toast.makeText(this, "Error opening story: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }
}
