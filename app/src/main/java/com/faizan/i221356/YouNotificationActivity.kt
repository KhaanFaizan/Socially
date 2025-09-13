package com.faizan.i221356

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class YouNotificationActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("YouNotificationActivity", "onCreate called - starting YouNotificationActivity")
        
        try {
            setContentView(R.layout.activity_you_notification)
            Log.d("YouNotificationActivity", "Layout set successfully")
        } catch (e: Exception) {
            Log.e("YouNotificationActivity", "Error setting content view: ${e.message}")
            Toast.makeText(this, "Error loading you notification layout: ${e.message}", Toast.LENGTH_LONG).show()
            return
        }

        Log.d("YouNotificationActivity", "YouNotificationActivity created successfully")
        Toast.makeText(this, "Your Notifications", Toast.LENGTH_SHORT).show()

        // Set up click listeners for interactive elements
        setupClickListeners()
        
        // Debug: Check if layout elements are found
        val followingTab = findViewById<LinearLayout>(R.id.followingTab)
        val youTab = findViewById<LinearLayout>(R.id.youTab)
        val followRequestsText = findViewById<TextView>(R.id.followRequestsText)
        val homeIcon = findViewById<ImageView>(R.id.homeIcon)
        val searchIcon = findViewById<ImageView>(R.id.searchIcon)
        val addPostIcon = findViewById<ImageView>(R.id.addPostIcon)
        val activityIcon = findViewById<ImageView>(R.id.activityIcon)
        val profileIcon = findViewById<ImageView>(R.id.profileIcon)
        
        Log.d("YouNotificationActivity", "followingTab found: ${followingTab != null}")
        Log.d("YouNotificationActivity", "youTab found: ${youTab != null}")
        Log.d("YouNotificationActivity", "followRequestsText found: ${followRequestsText != null}")
        Log.d("YouNotificationActivity", "homeIcon found: ${homeIcon != null}")
        Log.d("YouNotificationActivity", "searchIcon found: ${searchIcon != null}")
        Log.d("YouNotificationActivity", "addPostIcon found: ${addPostIcon != null}")
        Log.d("YouNotificationActivity", "activityIcon found: ${activityIcon != null}")
        Log.d("YouNotificationActivity", "profileIcon found: ${profileIcon != null}")
    }

    private fun setupClickListeners() {
        // Following tab
        val followingTab: LinearLayout = findViewById(R.id.followingTab)
        if (followingTab != null) {
            followingTab.setOnClickListener {
                Toast.makeText(this, "Switching to Following tab!", Toast.LENGTH_SHORT).show()
                try {
                    val intent = Intent(this, ActivityNotificationActivity::class.java)
                    startActivity(intent)
                    finish()
                    Log.d("YouNotificationActivity", "Navigating to ActivityNotificationActivity")
                } catch (e: Exception) {
                    Log.e("YouNotificationActivity", "Error navigating to ActivityNotificationActivity: ${e.message}")
                    Toast.makeText(this, "Error switching to Following tab: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        } else {
            Log.e("YouNotificationActivity", "Following tab not found!")
        }

        // You tab (already active)
        val youTab: LinearLayout = findViewById(R.id.youTab)
        if (youTab != null) {
            youTab.setOnClickListener {
                Toast.makeText(this, "Already on You tab!", Toast.LENGTH_SHORT).show()
            }
        } else {
            Log.e("YouNotificationActivity", "You tab not found!")
        }

        // Follow Requests
        val followRequestsText: TextView = findViewById(R.id.followRequestsText)
        if (followRequestsText != null) {
            followRequestsText.setOnClickListener {
                Toast.makeText(this, "Follow Requests feature coming soon!", Toast.LENGTH_SHORT).show()
            }
        } else {
            Log.e("YouNotificationActivity", "Follow Requests text not found!")
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
                    Log.d("YouNotificationActivity", "Navigating to FeedActivity")
                } catch (e: Exception) {
                    Log.e("YouNotificationActivity", "Error navigating to FeedActivity: ${e.message}")
                    Toast.makeText(this, "Error opening home page: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        } else {
            Log.e("YouNotificationActivity", "Home icon not found!")
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
                    Log.d("YouNotificationActivity", "Navigating to SearchActivity")
                } catch (e: Exception) {
                    Log.e("YouNotificationActivity", "Error navigating to SearchActivity: ${e.message}")
                    Toast.makeText(this, "Error opening search page: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        } else {
            Log.e("YouNotificationActivity", "Search icon not found!")
        }

        // Add post icon
        val addPostIcon: ImageView = findViewById(R.id.addPostIcon)
        if (addPostIcon != null) {
            addPostIcon.setOnClickListener {
                Toast.makeText(this, "Add post feature coming soon!", Toast.LENGTH_SHORT).show()
            }
        } else {
            Log.e("YouNotificationActivity", "Add post icon not found!")
        }

        // Activity icon (already active)
        val activityIcon: ImageView = findViewById(R.id.activityIcon)
        if (activityIcon != null) {
            activityIcon.setOnClickListener {
                Toast.makeText(this, "Already on activity page!", Toast.LENGTH_SHORT).show()
            }
        } else {
            Log.e("YouNotificationActivity", "Activity icon not found!")
        }

        // Profile icon
        val profileIcon: ImageView = findViewById(R.id.profileIcon)
        if (profileIcon != null) {
            profileIcon.setOnClickListener {
                Toast.makeText(this, "Profile feature coming soon!", Toast.LENGTH_SHORT).show()
            }
        } else {
            Log.e("YouNotificationActivity", "Profile icon not found!")
        }

        // Follow/Message buttons
        setupFollowMessageButtons()
    }

    private fun setupFollowMessageButtons() {
        // Follow button for mis_potter
        val followButton: TextView = findViewById(R.id.followButton)
        if (followButton != null) {
            followButton.setOnClickListener {
                Toast.makeText(this, "Following mis_potter!", Toast.LENGTH_SHORT).show()
                // Change button text to "Following" and style
                followButton.text = "Following"
                followButton.setBackgroundColor(android.graphics.Color.parseColor("#CCCCCC"))
                followButton.setTextColor(android.graphics.Color.parseColor("#666666"))
            }
        } else {
            Log.e("YouNotificationActivity", "Follow button not found!")
        }

        // Message buttons
        val messageButton1: TextView = findViewById(R.id.messageButton1)
        if (messageButton1 != null) {
            messageButton1.setOnClickListener {
                Toast.makeText(this, "Opening chat with martini_rond", Toast.LENGTH_SHORT).show()
                try {
                    val intent = Intent(this, DirectMessageActivity::class.java)
                    startActivity(intent)
                    Log.d("YouNotificationActivity", "Navigating to DirectMessageActivity for martini_rond")
                } catch (e: Exception) {
                    Log.e("YouNotificationActivity", "Error navigating to DirectMessageActivity: ${e.message}")
                    Toast.makeText(this, "Error opening chat: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        } else {
            Log.e("YouNotificationActivity", "Message button 1 not found!")
        }

        val messageButton2: TextView = findViewById(R.id.messageButton2)
        if (messageButton2 != null) {
            messageButton2.setOnClickListener {
                Toast.makeText(this, "Opening chat with maxjacobson", Toast.LENGTH_SHORT).show()
                try {
                    val intent = Intent(this, DirectMessageActivity::class.java)
                    startActivity(intent)
                    Log.d("YouNotificationActivity", "Navigating to DirectMessageActivity for maxjacobson")
                } catch (e: Exception) {
                    Log.e("YouNotificationActivity", "Error navigating to DirectMessageActivity: ${e.message}")
                    Toast.makeText(this, "Error opening chat: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        } else {
            Log.e("YouNotificationActivity", "Message button 2 not found!")
        }

        // Reply button
        val replyButton: TextView = findViewById(R.id.replyButton)
        if (replyButton != null) {
            replyButton.setOnClickListener {
                Toast.makeText(this, "Reply feature coming soon!", Toast.LENGTH_SHORT).show()
            }
        } else {
            Log.e("YouNotificationActivity", "Reply button not found!")
        }
    }
}
