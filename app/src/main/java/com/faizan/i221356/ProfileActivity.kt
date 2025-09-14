package com.faizan.i221356

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("ProfileActivity", "onCreate called - starting ProfileActivity")
        
        try {
            setContentView(R.layout.activity_profile)
            Log.d("ProfileActivity", "Layout set successfully")
        } catch (e: Exception) {
            Log.e("ProfileActivity", "Error setting content view: ${e.message}")
            Toast.makeText(this, "Error loading profile layout: ${e.message}", Toast.LENGTH_LONG).show()
            return
        }

        Log.d("ProfileActivity", "ProfileActivity created successfully")
        Toast.makeText(this, "Profile Page", Toast.LENGTH_SHORT).show()

        // Set up click listeners for interactive elements
        setupClickListeners()
        
        // Set up bio text with blue @pixsellz
        setupBioText()
        
        // Debug: Check if layout elements are found
        val usernameText = findViewById<TextView>(R.id.usernameText)
        val menuIcon = findViewById<ImageView>(R.id.menuIcon)
        val editProfileButton = findViewById<TextView>(R.id.editProfileButton)
        val homeIcon = findViewById<ImageView>(R.id.homeIcon)
        val searchIcon = findViewById<ImageView>(R.id.searchIcon)
        val addPostIcon = findViewById<ImageView>(R.id.addPostIcon)
        val activityIcon = findViewById<ImageView>(R.id.activityIcon)
        val profileIcon = findViewById<ImageView>(R.id.profileIcon)
        
        Log.d("ProfileActivity", "usernameText found: ${usernameText != null}")
        Log.d("ProfileActivity", "menuIcon found: ${menuIcon != null}")
        Log.d("ProfileActivity", "editProfileButton found: ${editProfileButton != null}")
        Log.d("ProfileActivity", "homeIcon found: ${homeIcon != null}")
        Log.d("ProfileActivity", "searchIcon found: ${searchIcon != null}")
        Log.d("ProfileActivity", "addPostIcon found: ${addPostIcon != null}")
        Log.d("ProfileActivity", "activityIcon found: ${activityIcon != null}")
        Log.d("ProfileActivity", "profileIcon found: ${profileIcon != null}")
    }

    private fun setupClickListeners() {
        // Username dropdown
        val usernameText: TextView = findViewById(R.id.usernameText)
        if (usernameText != null) {
            usernameText.setOnClickListener {
                Toast.makeText(this, "Account switching feature coming soon!", Toast.LENGTH_SHORT).show()
            }
        } else {
            Log.e("ProfileActivity", "Username text not found!")
        }

        // Menu icon
        val menuIcon: ImageView = findViewById(R.id.menuIcon)
        if (menuIcon != null) {
            menuIcon.setOnClickListener {
                Toast.makeText(this, "Menu feature coming soon!", Toast.LENGTH_SHORT).show()
            }
        } else {
            Log.e("ProfileActivity", "Menu icon not found!")
        }

        // Edit Profile button
        val editProfileButton: TextView = findViewById(R.id.editProfileButton)
        if (editProfileButton != null) {
            editProfileButton.setOnClickListener {
                Toast.makeText(this, "Opening Edit Profile!", Toast.LENGTH_SHORT).show()
                try {
                    val intent = Intent(this, EditProfileActivity::class.java)
                    startActivity(intent)
                    Log.d("ProfileActivity", "Navigating to EditProfileActivity")
                } catch (e: Exception) {
                    Log.e("ProfileActivity", "Error navigating to EditProfileActivity: ${e.message}")
                    Toast.makeText(this, "Error opening edit profile: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        } else {
            Log.e("ProfileActivity", "Edit Profile button not found!")
        }

        // Story highlights
        setupStoryHighlights()

        // Content tabs
        setupContentTabs()

        // Bottom navigation
        setupBottomNavigation()
    }

    private fun setupStoryHighlights() {
        // New highlight
        val newHighlight: LinearLayout = findViewById(R.id.newHighlight)
        if (newHighlight != null) {
            newHighlight.setOnClickListener {
                Toast.makeText(this, "Opening New highlights!", Toast.LENGTH_SHORT).show()
                try {
                    val intent = Intent(this, HighlightActivity::class.java)
                    intent.putExtra("highlight_type", "New")
                    startActivity(intent)
                    Log.d("ProfileActivity", "Navigating to HighlightActivity for New")
                } catch (e: Exception) {
                    Log.e("ProfileActivity", "Error navigating to HighlightActivity: ${e.message}")
                    Toast.makeText(this, "Error opening highlights: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        } else {
            Log.e("ProfileActivity", "New highlight not found!")
        }

        // Friends highlight
        val friendsHighlight: LinearLayout = findViewById(R.id.friendsHighlight)
        if (friendsHighlight != null) {
            friendsHighlight.setOnClickListener {
                Toast.makeText(this, "Opening Friends highlights!", Toast.LENGTH_SHORT).show()
                try {
                    val intent = Intent(this, HighlightActivity::class.java)
                    intent.putExtra("highlight_type", "Friends")
                    startActivity(intent)
                    Log.d("ProfileActivity", "Navigating to HighlightActivity for Friends")
                } catch (e: Exception) {
                    Log.e("ProfileActivity", "Error navigating to HighlightActivity: ${e.message}")
                    Toast.makeText(this, "Error opening highlights: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        } else {
            Log.e("ProfileActivity", "Friends highlight not found!")
        }

        // Sport highlight
        val sportHighlight: LinearLayout = findViewById(R.id.sportHighlight)
        if (sportHighlight != null) {
            sportHighlight.setOnClickListener {
                Toast.makeText(this, "Opening Sport highlights!", Toast.LENGTH_SHORT).show()
                try {
                    val intent = Intent(this, HighlightActivity::class.java)
                    intent.putExtra("highlight_type", "Sport")
                    startActivity(intent)
                    Log.d("ProfileActivity", "Navigating to HighlightActivity for Sport")
                } catch (e: Exception) {
                    Log.e("ProfileActivity", "Error navigating to HighlightActivity: ${e.message}")
                    Toast.makeText(this, "Error opening highlights: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        } else {
            Log.e("ProfileActivity", "Sport highlight not found!")
        }

        // Design highlight
        val designHighlight: LinearLayout = findViewById(R.id.designHighlight)
        if (designHighlight != null) {
            designHighlight.setOnClickListener {
                Toast.makeText(this, "Opening Design highlights!", Toast.LENGTH_SHORT).show()
                try {
                    val intent = Intent(this, HighlightActivity::class.java)
                    intent.putExtra("highlight_type", "Design")
                    startActivity(intent)
                    Log.d("ProfileActivity", "Navigating to HighlightActivity for Design")
                } catch (e: Exception) {
                    Log.e("ProfileActivity", "Error navigating to HighlightActivity: ${e.message}")
                    Toast.makeText(this, "Error opening highlights: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        } else {
            Log.e("ProfileActivity", "Design highlight not found!")
        }
    }

    private fun setupContentTabs() {
        // Grid tab (active)
        val gridTab: LinearLayout = findViewById(R.id.gridTab)
        if (gridTab != null) {
            gridTab.setOnClickListener {
                Toast.makeText(this, "Already on grid view!", Toast.LENGTH_SHORT).show()
            }
        } else {
            Log.e("ProfileActivity", "Grid tab not found!")
        }

        // Person tab
        val personTab: LinearLayout = findViewById(R.id.personTab)
        if (personTab != null) {
            personTab.setOnClickListener {
                Toast.makeText(this, "Person view coming soon!", Toast.LENGTH_SHORT).show()
            }
        } else {
            Log.e("ProfileActivity", "Person tab not found!")
        }
    }

    private fun setupBottomNavigation() {
        // Home icon navigation
        val homeIcon: ImageView = findViewById(R.id.homeIcon)
        if (homeIcon != null) {
            homeIcon.setOnClickListener {
                Toast.makeText(this, "Home icon clicked!", Toast.LENGTH_SHORT).show()
                try {
                    val intent = Intent(this, FeedActivity::class.java)
                    startActivity(intent)
                    finish()
                    Log.d("ProfileActivity", "Navigating to FeedActivity")
                } catch (e: Exception) {
                    Log.e("ProfileActivity", "Error navigating to FeedActivity: ${e.message}")
                    Toast.makeText(this, "Error opening home page: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        } else {
            Log.e("ProfileActivity", "Home icon not found!")
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
                    Log.d("ProfileActivity", "Navigating to SearchActivity")
                } catch (e: Exception) {
                    Log.e("ProfileActivity", "Error navigating to SearchActivity: ${e.message}")
                    Toast.makeText(this, "Error opening search page: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        } else {
            Log.e("ProfileActivity", "Search icon not found!")
        }

        // Add post icon
        val addPostIcon: ImageView = findViewById(R.id.addPostIcon)
        if (addPostIcon != null) {
            addPostIcon.setOnClickListener {
                Toast.makeText(this, "Add post feature coming soon!", Toast.LENGTH_SHORT).show()
            }
        } else {
            Log.e("ProfileActivity", "Add post icon not found!")
        }

        // Activity icon navigation
        val activityIcon: ImageView = findViewById(R.id.activityIcon)
        if (activityIcon != null) {
            activityIcon.setOnClickListener {
                Toast.makeText(this, "Activity icon clicked!", Toast.LENGTH_SHORT).show()
                try {
                    val intent = Intent(this, ActivityNotificationActivity::class.java)
                    startActivity(intent)
                    finish()
                    Log.d("ProfileActivity", "Navigating to ActivityNotificationActivity")
                } catch (e: Exception) {
                    Log.e("ProfileActivity", "Error navigating to ActivityNotificationActivity: ${e.message}")
                    Toast.makeText(this, "Error opening activity page: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        } else {
            Log.e("ProfileActivity", "Activity icon not found!")
        }

        // Profile icon (already active)
        val profileIcon: ImageView = findViewById(R.id.profileIcon)
        if (profileIcon != null) {
            profileIcon.setOnClickListener {
                Toast.makeText(this, "Already on profile page!", Toast.LENGTH_SHORT).show()
            }
        } else {
            Log.e("ProfileActivity", "Profile icon not found!")
        }
    }

    private fun setupBioText() {
        val bioText: TextView = findViewById(R.id.bioText)
        if (bioText != null) {
            val fullText = "Digital goodies designer @pixsellz"
            val spannableString = SpannableString(fullText)
            
            // Find the position of @pixsellz
            val pixsellzStart = fullText.indexOf("@pixsellz")
            if (pixsellzStart != -1) {
                val pixsellzEnd = pixsellzStart + "@pixsellz".length
                spannableString.setSpan(
                    ForegroundColorSpan(Color.BLUE),
                    pixsellzStart,
                    pixsellzEnd,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
            
            bioText.text = spannableString
            Log.d("ProfileActivity", "Bio text styled with blue @pixsellz")
        } else {
            Log.e("ProfileActivity", "Bio text not found!")
        }
    }
}
