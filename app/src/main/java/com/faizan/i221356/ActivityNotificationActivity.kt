package com.faizan.i221356

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ActivityNotificationActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("ActivityNotificationActivity", "onCreate called - starting ActivityNotificationActivity")
        
        try {
            setContentView(R.layout.activity_activity_notification)
            Log.d("ActivityNotificationActivity", "Layout set successfully")
        } catch (e: Exception) {
            Log.e("ActivityNotificationActivity", "Error setting content view: ${e.message}")
            Toast.makeText(this, "Error loading activity notification layout: ${e.message}", Toast.LENGTH_LONG).show()
            return
        }

        Log.d("ActivityNotificationActivity", "ActivityNotificationActivity created successfully")
        Toast.makeText(this, "Activity Notifications", Toast.LENGTH_SHORT).show()

        // Set up click listeners for interactive elements
        setupClickListeners()
        
        // Debug: Check if layout elements are found
        val followingTab = findViewById<LinearLayout>(R.id.followingTab)
        val youTab = findViewById<LinearLayout>(R.id.youTab)
        val homeIcon = findViewById<ImageView>(R.id.homeIcon)
        val searchIcon = findViewById<ImageView>(R.id.searchIcon)
        val addPostIcon = findViewById<ImageView>(R.id.addPostIcon)
        val activityIcon = findViewById<ImageView>(R.id.activityIcon)
        val profileIcon = findViewById<ImageView>(R.id.profileIcon)
        
        Log.d("ActivityNotificationActivity", "followingTab found: ${followingTab != null}")
        Log.d("ActivityNotificationActivity", "youTab found: ${youTab != null}")
        Log.d("ActivityNotificationActivity", "homeIcon found: ${homeIcon != null}")
        Log.d("ActivityNotificationActivity", "searchIcon found: ${searchIcon != null}")
        Log.d("ActivityNotificationActivity", "addPostIcon found: ${addPostIcon != null}")
        Log.d("ActivityNotificationActivity", "activityIcon found: ${activityIcon != null}")
        Log.d("ActivityNotificationActivity", "profileIcon found: ${profileIcon != null}")
    }

    private fun setupClickListeners() {
        // Following tab
        val followingTab: LinearLayout = findViewById(R.id.followingTab)
        if (followingTab != null) {
            followingTab.setOnClickListener {
                Toast.makeText(this, "Following tab clicked!", Toast.LENGTH_SHORT).show()
                // Switch to Following tab (already active)
            }
        } else {
            Log.e("ActivityNotificationActivity", "Following tab not found!")
        }

        // You tab
        val youTab: LinearLayout = findViewById(R.id.youTab)
        if (youTab != null) {
            youTab.setOnClickListener {
                Toast.makeText(this, "Switching to You tab!", Toast.LENGTH_SHORT).show()
                try {
                    val intent = Intent(this, YouNotificationActivity::class.java)
                    startActivity(intent)
                    finish()
                    Log.d("ActivityNotificationActivity", "Navigating to YouNotificationActivity")
                } catch (e: Exception) {
                    Log.e("ActivityNotificationActivity", "Error navigating to YouNotificationActivity: ${e.message}")
                    Toast.makeText(this, "Error switching to You tab: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        } else {
            Log.e("ActivityNotificationActivity", "You tab not found!")
        }

        // Home icon navigation
        val homeIcon: ImageView = findViewById(R.id.homeIcon)
        if (homeIcon != null) {
            homeIcon.setOnClickListener {
                Toast.makeText(this, "Home icon clicked!", Toast.LENGTH_SHORT).show()
                try {
                    val intent = Intent(this, FeedActivity::class.java)
                    startActivity(intent)
                    finish()
                    Log.d("ActivityNotificationActivity", "Navigating to FeedActivity")
                } catch (e: Exception) {
                    Log.e("ActivityNotificationActivity", "Error navigating to FeedActivity: ${e.message}")
                    Toast.makeText(this, "Error opening home page: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        } else {
            Log.e("ActivityNotificationActivity", "Home icon not found!")
        }

        // Search icon navigation
        val searchIcon: ImageView = findViewById(R.id.searchIcon)
        if (searchIcon != null) {
            searchIcon.setOnClickListener {
                Toast.makeText(this, "Search icon clicked!", Toast.LENGTH_SHORT).show()
                try {
                    val intent = Intent(this, SearchActivity::class.java)
                    startActivity(intent)
                    finish()
                    Log.d("ActivityNotificationActivity", "Navigating to SearchActivity")
                } catch (e: Exception) {
                    Log.e("ActivityNotificationActivity", "Error navigating to SearchActivity: ${e.message}")
                    Toast.makeText(this, "Error opening search page: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        } else {
            Log.e("ActivityNotificationActivity", "Search icon not found!")
        }

        // Add post icon
        val addPostIcon: ImageView = findViewById(R.id.addPostIcon)
        if (addPostIcon != null) {
            addPostIcon.setOnClickListener {
                Toast.makeText(this, "Add post feature coming soon!", Toast.LENGTH_SHORT).show()
            }
        } else {
            Log.e("ActivityNotificationActivity", "Add post icon not found!")
        }

        // Activity icon (already active)
        val activityIcon: ImageView = findViewById(R.id.activityIcon)
        if (activityIcon != null) {
            activityIcon.setOnClickListener {
                Toast.makeText(this, "Already on activity page!", Toast.LENGTH_SHORT).show()
            }
        } else {
            Log.e("ActivityNotificationActivity", "Activity icon not found!")
        }

        // Profile icon
        val profileIcon: ImageView = findViewById(R.id.profileIcon)
        if (profileIcon != null) {
            profileIcon.setOnClickListener {
                Toast.makeText(this, "Profile icon clicked!", Toast.LENGTH_SHORT).show()
                try {
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    Log.d("ActivityNotificationActivity", "Navigating to ProfileActivity")
                } catch (e: Exception) {
                    Log.e("ActivityNotificationActivity", "Error navigating to ProfileActivity: ${e.message}")
                    Toast.makeText(this, "Error opening profile page: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        } else {
            Log.e("ActivityNotificationActivity", "Profile icon not found!")
            Toast.makeText(this, "Profile icon not found!", Toast.LENGTH_SHORT).show()
        }
    }
}
