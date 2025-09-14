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

class UploadContentActivity : AppCompatActivity() {

    private var selectedImageIndex = 0
    private val sampleImages = listOf(
        R.drawable.shutterstock_1163329165,
        R.drawable.shutterstock_1163329165,
        R.drawable.shutterstock_1163329165,
        R.drawable.shutterstock_1163329165,
        R.drawable.shutterstock_1163329165,
        R.drawable.shutterstock_1163329165,
        R.drawable.shutterstock_1163329165,
        R.drawable.shutterstock_1163329165,
        R.drawable.shutterstock_1163329165,
        R.drawable.shutterstock_1163329165,
        R.drawable.shutterstock_1163329165,
        R.drawable.shutterstock_1163329165
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_content)

        Log.d("UploadContentActivity", "UploadContentActivity created successfully")
        Toast.makeText(this, "Upload Content Page", Toast.LENGTH_SHORT).show()

        setupClickListeners()
        setupThumbnailGrid()
        updateMainPreview()
    }

    private fun setupClickListeners() {
        // Cancel button
        findViewById<TextView>(R.id.cancelButton).setOnClickListener {
            Toast.makeText(this, "Upload cancelled", Toast.LENGTH_SHORT).show()
            finish()
        }

        // Next button
        findViewById<TextView>(R.id.nextButton).setOnClickListener {
            Toast.makeText(this, "Proceeding to next step", Toast.LENGTH_SHORT).show()
            // Here you would typically navigate to a caption/compose screen
            finish()
        }

        // Recents dropdown
        findViewById<LinearLayout>(R.id.recentsDropdown).setOnClickListener {
            Toast.makeText(this, "Recents dropdown clicked", Toast.LENGTH_SHORT).show()
        }

        // Bottom navigation tabs
        findViewById<LinearLayout>(R.id.libraryTab).setOnClickListener {
            Toast.makeText(this, "Library tab selected", Toast.LENGTH_SHORT).show()
            updateTabSelection("library")
        }

        findViewById<LinearLayout>(R.id.photoTab).setOnClickListener {
            Toast.makeText(this, "Photo tab selected", Toast.LENGTH_SHORT).show()
            updateTabSelection("photo")
        }

        findViewById<LinearLayout>(R.id.videoTab).setOnClickListener {
            Toast.makeText(this, "Video tab selected", Toast.LENGTH_SHORT).show()
            updateTabSelection("video")
        }

        // Overlay controls
        findViewById<ImageView>(R.id.infinityIcon).setOnClickListener {
            Toast.makeText(this, "Infinity mode selected", Toast.LENGTH_SHORT).show()
        }

        findViewById<ImageView>(R.id.gridIcon).setOnClickListener {
            Toast.makeText(this, "Grid view toggled", Toast.LENGTH_SHORT).show()
        }

        findViewById<ImageView>(R.id.selectMultipleIcon).setOnClickListener {
            Toast.makeText(this, "Multiple selection toggled", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupThumbnailGrid() {
        val thumbnailContainer = findViewById<LinearLayout>(R.id.thumbnailContainer)
        
        // Clear existing thumbnails
        thumbnailContainer.removeAllViews()
        
        // Create thumbnail rows (4 columns each)
        for (i in sampleImages.indices step 4) {
            val rowLayout = LinearLayout(this).apply {
                orientation = LinearLayout.HORIZONTAL
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
            }
            
            // Add up to 4 thumbnails per row
            for (j in 0 until 4) {
                val imageIndex = i + j
                if (imageIndex < sampleImages.size) {
                    val thumbnail = createThumbnail(imageIndex)
                    rowLayout.addView(thumbnail)
                }
            }
            
            thumbnailContainer.addView(rowLayout)
        }
    }

    private fun createThumbnail(index: Int): ImageView {
        val thumbnail = ImageView(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                0,
                120.dpToPx(),
                1f
            ).apply {
                setMargins(2.dpToPx(), 2.dpToPx(), 2.dpToPx(), 2.dpToPx())
            }
            setImageResource(sampleImages[index])
            scaleType = ImageView.ScaleType.CENTER_CROP
            setOnClickListener {
                selectedImageIndex = index
                updateMainPreview()
                updateThumbnailSelection()
                Toast.makeText(this@UploadContentActivity, "Image $index selected", Toast.LENGTH_SHORT).show()
            }
        }
        return thumbnail
    }

    private fun updateMainPreview() {
        val mainPreview = findViewById<ImageView>(R.id.mainPreview)
        mainPreview.setImageResource(sampleImages[selectedImageIndex])
    }

    private fun updateThumbnailSelection() {
        val thumbnailContainer = findViewById<LinearLayout>(R.id.thumbnailContainer)
        for (i in 0 until thumbnailContainer.childCount) {
            val row = thumbnailContainer.getChildAt(i) as LinearLayout
            for (j in 0 until row.childCount) {
                val thumbnail = row.getChildAt(j) as ImageView
                val imageIndex = i * 4 + j
                if (imageIndex < sampleImages.size) {
                    if (imageIndex == selectedImageIndex) {
                        thumbnail.alpha = 0.7f
                        thumbnail.setBackgroundColor(0x33FF8B4513.toInt())
                    } else {
                        thumbnail.alpha = 1.0f
                        thumbnail.setBackgroundColor(0x00000000)
                    }
                }
            }
        }
    }

    private fun updateTabSelection(selectedTab: String) {
        // Reset all tabs
        findViewById<TextView>(R.id.libraryTabText).setTextColor(0x80FF8B4513.toInt())
        findViewById<TextView>(R.id.photoTabText).setTextColor(0x80FF8B4513.toInt())
        findViewById<TextView>(R.id.videoTabText).setTextColor(0x80FF8B4513.toInt())
        
        findViewById<View>(R.id.libraryTabIndicator).visibility = View.INVISIBLE
        findViewById<View>(R.id.photoTabIndicator).visibility = View.INVISIBLE
        findViewById<View>(R.id.videoTabIndicator).visibility = View.INVISIBLE

        // Highlight selected tab
        when (selectedTab) {
            "library" -> {
                findViewById<TextView>(R.id.libraryTabText).setTextColor(0xFFFF8B4513.toInt())
                findViewById<View>(R.id.libraryTabIndicator).visibility = View.VISIBLE
            }
            "photo" -> {
                findViewById<TextView>(R.id.photoTabText).setTextColor(0xFFFF8B4513.toInt())
                findViewById<View>(R.id.photoTabIndicator).visibility = View.VISIBLE
            }
            "video" -> {
                findViewById<TextView>(R.id.videoTabText).setTextColor(0xFFFF8B4513.toInt())
                findViewById<View>(R.id.videoTabIndicator).visibility = View.VISIBLE
            }
        }
    }

    private fun Int.dpToPx(): Int = (this * resources.displayMetrics.density).toInt()
}