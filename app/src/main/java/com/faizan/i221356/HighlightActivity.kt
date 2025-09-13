package com.faizan.i221356

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HighlightActivity : AppCompatActivity() {
    
    private var currentStoryIndex = 0
    private var highlightType = ""
    private val stories = mutableListOf<StoryData>()
    private var storyHandler: Handler? = null
    private var storyRunnable: Runnable? = null
    private val STORY_DURATION = 3000L // 3 seconds per story
    
    data class StoryData(
        val imageRes: Int,
        val title: String,
        val date: String,
        val musicInfo: String
    )
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("HighlightActivity", "onCreate called - starting HighlightActivity")
        
        // Get highlight type from intent
        highlightType = intent.getStringExtra("highlight_type") ?: "New"
        
        try {
            setContentView(R.layout.activity_highlight)
            Log.d("HighlightActivity", "Layout set successfully")
        } catch (e: Exception) {
            Log.e("HighlightActivity", "Error setting content view: ${e.message}")
            Toast.makeText(this, "Error loading highlight layout: ${e.message}", Toast.LENGTH_LONG).show()
            return
        }

        Log.d("HighlightActivity", "HighlightActivity created successfully for: $highlightType")
        Toast.makeText(this, "Viewing $highlightType highlights", Toast.LENGTH_SHORT).show()

        // Set up stories data
        setupStoriesData()
        
        // Set up click listeners
        setupClickListeners()
        
        // Display current story
        displayCurrentStory()
        
        // Start automatic story progression
        startStoryProgression()
    }
    
    private fun setupStoriesData() {
        when (highlightType) {
            "New" -> {
                stories.addAll(listOf(
                    StoryData(R.drawable.shutterstock_100407100, "New Story 1", "December 3, 2023", "Artist • Song Title"),
                    StoryData(R.drawable.shutterstock_1011776404, "New Story 2", "December 2, 2023", "Artist • Another Song"),
                    StoryData(R.drawable.shutterstock_1163329165, "New Story 3", "December 1, 2023", "Artist • Third Song")
                ))
            }
            "Friends" -> {
                stories.addAll(listOf(
                    StoryData(R.drawable.shutterstock_100407100, "Friends Story 1", "December 3, 2023", "Artist • Song Title"),
                    StoryData(R.drawable.shutterstock_1011776404, "Friends Story 2", "December 2, 2023", "Artist • Another Song"),
                    StoryData(R.drawable.shutterstock_1163329165, "Friends Story 3", "December 1, 2023", "Artist • Third Song")
                ))
            }
            "Sport" -> {
                stories.addAll(listOf(
                    StoryData(R.drawable.shutterstock_1011776404, "Sport Story 1", "December 3, 2023", "Artist • Song Title"),
                    StoryData(R.drawable.shutterstock_100407100, "Sport Story 2", "December 2, 2023", "Artist • Another Song"),
                    StoryData(R.drawable.shutterstock_1163329165, "Sport Story 3", "December 1, 2023", "Artist • Third Song")
                ))
            }
            "Design" -> {
                stories.addAll(listOf(
                    StoryData(R.drawable.shutterstock_1163329165, "Design Story 1", "December 3, 2023", "Artist • Song Title"),
                    StoryData(R.drawable.shutterstock_100407100, "Design Story 2", "December 2, 2023", "Artist • Another Song"),
                    StoryData(R.drawable.shutterstock_1011776404, "Design Story 3", "December 1, 2023", "Artist • Third Song")
                ))
            }
        }
        
        Log.d("HighlightActivity", "Loaded ${stories.size} stories for $highlightType")
    }
    
    private fun setupClickListeners() {
        // Close button
        val closeButton: ImageView = findViewById(R.id.closeButton)
        if (closeButton != null) {
            closeButton.setOnClickListener {
                finish()
                Log.d("HighlightActivity", "Closing highlight view")
            }
        } else {
            Log.e("HighlightActivity", "Close button not found!")
        }
        
        // Left side tap (previous story)
        val leftTapArea: LinearLayout = findViewById(R.id.leftTapArea)
        if (leftTapArea != null) {
            leftTapArea.setOnClickListener {
                previousStory()
            }
        } else {
            Log.e("HighlightActivity", "Left tap area not found!")
        }
        
        // Right side tap (next story)
        val rightTapArea: LinearLayout = findViewById(R.id.rightTapArea)
        if (rightTapArea != null) {
            rightTapArea.setOnClickListener {
                nextStory()
            }
        } else {
            Log.e("HighlightActivity", "Right tap area not found!")
        }
        
        // Bottom navigation
        setupBottomNavigation()
    }
    
    private fun setupBottomNavigation() {
        // Activity icon
        val activityIcon: ImageView = findViewById(R.id.activityIcon)
        if (activityIcon != null) {
            activityIcon.setOnClickListener {
                try {
                    val intent = Intent(this, ActivityNotificationActivity::class.java)
                    startActivity(intent)
                    finish()
                    Log.d("HighlightActivity", "Navigating to ActivityNotificationActivity")
                } catch (e: Exception) {
                    Log.e("HighlightActivity", "Error navigating to ActivityNotificationActivity: ${e.message}")
                }
            }
        }
        
        // Create icon
        val createIcon: ImageView = findViewById(R.id.createIcon)
        if (createIcon != null) {
            createIcon.setOnClickListener {
                Toast.makeText(this, "Create feature coming soon!", Toast.LENGTH_SHORT).show()
            }
        }
        
        // Create Post icon
        val createPostIcon: ImageView = findViewById(R.id.createPostIcon)
        if (createPostIcon != null) {
            createPostIcon.setOnClickListener {
                Toast.makeText(this, "Create Post feature coming soon!", Toast.LENGTH_SHORT).show()
            }
        }
        
        // Browse icon
        val browseIcon: ImageView = findViewById(R.id.browseIcon)
        if (browseIcon != null) {
            browseIcon.setOnClickListener {
                try {
                    val intent = Intent(this, SearchActivity::class.java)
                    startActivity(intent)
                    finish()
                    Log.d("HighlightActivity", "Navigating to SearchActivity")
                } catch (e: Exception) {
                    Log.e("HighlightActivity", "Error navigating to SearchActivity: ${e.message}")
                }
            }
        }
        
        // Send icon
        val sendIcon: ImageView = findViewById(R.id.sendIcon)
        if (sendIcon != null) {
            sendIcon.setOnClickListener {
                try {
                    val intent = Intent(this, MessagesActivity::class.java)
                    startActivity(intent)
                    finish()
                    Log.d("HighlightActivity", "Navigating to MessagesActivity")
                } catch (e: Exception) {
                    Log.e("HighlightActivity", "Error navigating to MessagesActivity: ${e.message}")
                }
            }
        }
        
        // More icon
        val moreIcon: ImageView = findViewById(R.id.moreIcon)
        if (moreIcon != null) {
            moreIcon.setOnClickListener {
                Toast.makeText(this, "More options coming soon!", Toast.LENGTH_SHORT).show()
            }
        }
    }
    
    private fun displayCurrentStory() {
        if (stories.isEmpty()) {
            Log.e("HighlightActivity", "No stories available")
            return
        }
        
        val story = stories[currentStoryIndex]
        
        // Update story image
        val storyImage: ImageView = findViewById(R.id.storyImage)
        if (storyImage != null) {
            storyImage.setImageResource(story.imageRes)
        }
        
        // Update story title
        val storyTitle: TextView = findViewById(R.id.storyTitle)
        if (storyTitle != null) {
            storyTitle.text = story.title
        }
        
        // Update story date
        val storyDate: TextView = findViewById(R.id.storyDate)
        if (storyDate != null) {
            storyDate.text = story.date
        }
        
        // Update music info
        val musicInfo: TextView = findViewById(R.id.musicInfo)
        if (musicInfo != null) {
            musicInfo.text = story.musicInfo
        }
        
        // Update highlight title
        val highlightTitle: TextView = findViewById(R.id.highlightTitle)
        if (highlightTitle != null) {
            highlightTitle.text = highlightType
        }
        
        // Update progress bar
        updateProgressBar()
        
        Log.d("HighlightActivity", "Displaying story ${currentStoryIndex + 1}/${stories.size}: ${story.title}")
    }
    
    private fun nextStory() {
        stopStoryProgression()
        if (currentStoryIndex < stories.size - 1) {
            currentStoryIndex++
            displayCurrentStory()
            startStoryProgression()
            Toast.makeText(this, "Next story", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Last story", Toast.LENGTH_SHORT).show()
            startStoryProgression()
        }
    }
    
    private fun previousStory() {
        stopStoryProgression()
        if (currentStoryIndex > 0) {
            currentStoryIndex--
            displayCurrentStory()
            updateProgressBar()
            startStoryProgression()
            Toast.makeText(this, "Previous story", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "First story", Toast.LENGTH_SHORT).show()
            startStoryProgression()
        }
    }
    
    private fun startStoryProgression() {
        stopStoryProgression()
        storyHandler = Handler(Looper.getMainLooper())
        storyRunnable = object : Runnable {
            override fun run() {
                if (currentStoryIndex < stories.size - 1) {
                    currentStoryIndex++
                    displayCurrentStory()
                    updateProgressBar()
                    storyHandler?.postDelayed(this, STORY_DURATION)
                } else {
                    // Last story reached, go back to profile
                    finish()
                }
            }
        }
        storyHandler?.postDelayed(storyRunnable!!, STORY_DURATION)
    }
    
    private fun stopStoryProgression() {
        storyRunnable?.let { storyHandler?.removeCallbacks(it) }
    }
    
    private fun updateProgressBar() {
        val progressSegment1: View = findViewById(R.id.progressSegment1)
        val progressSegment2: View = findViewById(R.id.progressSegment2)
        val progressSegment3: View = findViewById(R.id.progressSegment3)
        
        // Reset all segments
        progressSegment1.setBackgroundColor(0x33FFFFFF.toInt()) // Semi-transparent white
        progressSegment2.setBackgroundColor(0x33FFFFFF.toInt())
        progressSegment3.setBackgroundColor(0x33FFFFFF.toInt())
        
        // Fill segments based on current story index
        when (currentStoryIndex) {
            0 -> progressSegment1.setBackgroundColor(0xFFFFFFFF.toInt()) // Full white
            1 -> {
                progressSegment1.setBackgroundColor(0xFFFFFFFF.toInt())
                progressSegment2.setBackgroundColor(0xFFFFFFFF.toInt())
            }
            2 -> {
                progressSegment1.setBackgroundColor(0xFFFFFFFF.toInt())
                progressSegment2.setBackgroundColor(0xFFFFFFFF.toInt())
                progressSegment3.setBackgroundColor(0xFFFFFFFF.toInt())
            }
        }
    }
    
    override fun onDestroy() {
        super.onDestroy()
        stopStoryProgression()
    }
    
    override fun onPause() {
        super.onPause()
        stopStoryProgression()
    }
    
    override fun onResume() {
        super.onResume()
        if (stories.isNotEmpty()) {
            startStoryProgression()
        }
    }
}
