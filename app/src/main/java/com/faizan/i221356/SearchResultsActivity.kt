package com.faizan.i221356

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SearchResultsActivity : AppCompatActivity() {
    
    override fun onStart() {
        super.onStart()
        Log.d("SearchResultsActivity", "onStart called")
    }
    
    override fun onResume() {
        super.onResume()
        Log.d("SearchResultsActivity", "onResume called")
        Toast.makeText(this, "SearchResultsActivity is now visible!", Toast.LENGTH_LONG).show()
    }
    
    override fun onPause() {
        super.onPause()
        Log.d("SearchResultsActivity", "onPause called")
    }
    
    override fun onStop() {
        super.onStop()
        Log.d("SearchResultsActivity", "onStop called")
    }
    
    override fun onDestroy() {
        super.onDestroy()
        Log.d("SearchResultsActivity", "onDestroy called")
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("SearchResultsActivity", "onCreate called - starting activity creation")
        
        try {
            setContentView(R.layout.activity_search_results)
            Log.d("SearchResultsActivity", "Layout set successfully")
        } catch (e: Exception) {
            Log.e("SearchResultsActivity", "Error setting content view: ${e.message}")
            Toast.makeText(this, "Error loading search results layout: ${e.message}", Toast.LENGTH_LONG).show()
            return
        }

        Log.d("SearchResultsActivity", "SearchResultsActivity created successfully")
        Toast.makeText(this, "Search results for imrankhan", Toast.LENGTH_SHORT).show()

        // Set up click listeners for interactive elements
        setupClickListeners()
        
        // Debug: Check if layout elements are found
        val clearButton = findViewById<TextView>(R.id.clearButton)
        val homeIcon = findViewById<ImageView>(R.id.homeIcon)
        val searchIcon = findViewById<ImageView>(R.id.searchBottomIcon)
        val firstSearchResult = findViewById<LinearLayout>(R.id.firstSearchResult)
        
        Log.d("SearchResultsActivity", "clearButton found: ${clearButton != null}")
        Log.d("SearchResultsActivity", "homeIcon found: ${homeIcon != null}")
        Log.d("SearchResultsActivity", "searchIcon found: ${searchIcon != null}")
        Log.d("SearchResultsActivity", "firstSearchResult found: ${firstSearchResult != null}")
    }

    private fun setupClickListeners() {
        // Clear button
        val clearButton: TextView = findViewById(R.id.clearButton)
        if (clearButton != null) {
            clearButton.setOnClickListener {
                Toast.makeText(this, "Clear button clicked!", Toast.LENGTH_SHORT).show()
                try {
                    val intent = Intent(this, SearchActivity::class.java)
                    startActivity(intent)
                    finish()
                    Log.d("SearchResultsActivity", "Clearing search and returning to search page")
                } catch (e: Exception) {
                    Log.e("SearchResultsActivity", "Error clearing search: ${e.message}")
                    Toast.makeText(this, "Error clearing search: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        } else {
            Log.e("SearchResultsActivity", "Clear button not found!")
            Toast.makeText(this, "Clear button not found!", Toast.LENGTH_SHORT).show()
        }

        // Tab navigation
        val topTab: LinearLayout = findViewById(R.id.topTab)
        topTab.setOnClickListener {
            Toast.makeText(this, "Top tab selected", Toast.LENGTH_SHORT).show()
        }

        val accountsTab: LinearLayout = findViewById(R.id.accountsTab)
        accountsTab.setOnClickListener {
            Toast.makeText(this, "Accounts tab selected", Toast.LENGTH_SHORT).show()
        }

        val tagsTab: LinearLayout = findViewById(R.id.tagsTab)
        tagsTab.setOnClickListener {
            Toast.makeText(this, "Tags tab selected", Toast.LENGTH_SHORT).show()
        }

        val placesTab: LinearLayout = findViewById(R.id.placesTab)
        placesTab.setOnClickListener {
            Toast.makeText(this, "Places tab selected", Toast.LENGTH_SHORT).show()
        }

        // Home icon navigation
        val homeIcon: ImageView = findViewById(R.id.homeIcon)
        homeIcon.setOnClickListener {
            try {
                val intent = Intent(this, FeedActivity::class.java)
                startActivity(intent)
                finish()
                Log.d("SearchResultsActivity", "Navigating to FeedActivity")
            } catch (e: Exception) {
                Log.e("SearchResultsActivity", "Error navigating to FeedActivity: ${e.message}")
                Toast.makeText(this, "Error opening home page", Toast.LENGTH_SHORT).show()
            }
        }

        // Search icon (already active)
        val searchIcon: ImageView = findViewById(R.id.searchBottomIcon)
        searchIcon.setOnClickListener {
            Toast.makeText(this, "Already on search results!", Toast.LENGTH_SHORT).show()
        }

        // Add Post icon
        val addPostIcon: ImageView = findViewById(R.id.addPostIcon)
        addPostIcon.setOnClickListener {
            Toast.makeText(this, "Create post feature coming soon!", Toast.LENGTH_SHORT).show()
        }

        // Activity icon
        val activityIcon: ImageView = findViewById(R.id.activityIcon)
        activityIcon.setOnClickListener {
            Toast.makeText(this, "Activity feature coming soon!", Toast.LENGTH_SHORT).show()
        }

        // Profile icon
        val profileIcon: ImageView = findViewById(R.id.profileIcon)
        if (profileIcon != null) {
            profileIcon.setOnClickListener {
                Toast.makeText(this, "Profile icon clicked!", Toast.LENGTH_SHORT).show()
                try {
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    Log.d("SearchResultsActivity", "Navigating to ProfileActivity")
                } catch (e: Exception) {
                    Log.e("SearchResultsActivity", "Error navigating to ProfileActivity: ${e.message}")
                    Toast.makeText(this, "Error opening profile page: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        } else {
            Log.e("SearchResultsActivity", "Profile icon not found!")
            Toast.makeText(this, "Profile icon not found!", Toast.LENGTH_SHORT).show()
        }

        // First search result - no navigation (search results only)
        val firstSearchResult: LinearLayout = findViewById(R.id.firstSearchResult)
        if (firstSearchResult != null) {
            firstSearchResult.setOnClickListener {
                Toast.makeText(this, "Search result clicked - no navigation", Toast.LENGTH_SHORT).show()
            }
        } else {
            Log.e("SearchResultsActivity", "First search result not found!")
            Toast.makeText(this, "First search result not found!", Toast.LENGTH_SHORT).show()
        }
    }
}
