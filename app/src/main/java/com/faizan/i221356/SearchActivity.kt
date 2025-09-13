package com.faizan.i221356

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        Log.d("SearchActivity", "SearchActivity created successfully")
        Toast.makeText(this, "Welcome to Search!", Toast.LENGTH_SHORT).show()

        // Set up click listeners for interactive elements
        setupClickListeners()
    }

    private fun setupClickListeners() {
        // Search input click listener
        val searchInputLayout: LinearLayout = findViewById(R.id.searchInputLayout)
        if (searchInputLayout != null) {
            searchInputLayout.setOnClickListener {
                Toast.makeText(this, "Search input clicked!", Toast.LENGTH_SHORT).show()
                try {
                    Log.d("SearchActivity", "Creating Intent for SearchResultsActivity")
                    val intent = Intent(this, SearchResultsActivity::class.java)
                    Log.d("SearchActivity", "Starting SearchResultsActivity")
                    startActivity(intent)
                    Log.d("SearchActivity", "Successfully started SearchResultsActivity")
                } catch (e: Exception) {
                    Log.e("SearchActivity", "Error navigating to SearchResultsActivity: ${e.message}")
                    Toast.makeText(this, "Error opening search results: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        } else {
            Log.e("SearchActivity", "Search input layout not found!")
            Toast.makeText(this, "Search input layout not found!", Toast.LENGTH_SHORT).show()
        }

        // Home icon navigation
        val homeIcon: ImageView = findViewById(R.id.homeIcon)
        homeIcon.setOnClickListener {
            try {
                Log.d("SearchActivity", "Home icon clicked - navigating to FeedActivity")
                val intent = Intent(this, FeedActivity::class.java)
                startActivity(intent)
                finish()
                Log.d("SearchActivity", "Successfully navigated to FeedActivity")
            } catch (e: Exception) {
                Log.e("SearchActivity", "Error navigating to FeedActivity: ${e.message}")
                Toast.makeText(this, "Error opening home page", Toast.LENGTH_SHORT).show()
            }
        }

        // Search icon - navigate to search results
        val searchIcon: ImageView = findViewById(R.id.searchBottomIcon)
        if (searchIcon != null) {
            searchIcon.setOnClickListener {
                Toast.makeText(this, "Search icon clicked!", Toast.LENGTH_SHORT).show()
                try {
                    Log.d("SearchActivity", "Search icon clicked - navigating to SearchResultsActivity")
                    val intent = Intent(this, SearchResultsActivity::class.java)
                    startActivity(intent)
                    Log.d("SearchActivity", "Successfully navigated to SearchResultsActivity")
                } catch (e: Exception) {
                    Log.e("SearchActivity", "Error navigating to SearchResultsActivity: ${e.message}")
                    Toast.makeText(this, "Error opening search results: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        } else {
            Log.e("SearchActivity", "Search icon not found!")
            Toast.makeText(this, "Search icon not found!", Toast.LENGTH_SHORT).show()
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
                    Log.d("SearchActivity", "Navigating to ProfileActivity")
                } catch (e: Exception) {
                    Log.e("SearchActivity", "Error navigating to ProfileActivity: ${e.message}")
                    Toast.makeText(this, "Error opening profile page: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        } else {
            Log.e("SearchActivity", "Profile icon not found!")
            Toast.makeText(this, "Profile icon not found!", Toast.LENGTH_SHORT).show()
        }
    }
}
