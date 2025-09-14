package com.faizan.i221356

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CameraActivity : AppCompatActivity() {

    private var isFlashOn = false
    private var isFrontCamera = false
    private var currentMode = "NORMAL"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

        Log.d("CameraActivity", "CameraActivity created successfully")
        Toast.makeText(this, "Camera Screen", Toast.LENGTH_SHORT).show()

        setupClickListeners()
        setupCameraModes()
    }

    private fun setupClickListeners() {
        // Gallery thumbnail
        findViewById<ImageView>(R.id.galleryThumbnail).setOnClickListener {
            Toast.makeText(this, "Opening gallery", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, UploadContentActivity::class.java)
            startActivity(intent)
        }

        // Flash toggle
        findViewById<ImageView>(R.id.flashButton).setOnClickListener {
            toggleFlash()
        }

        // Camera switch
        findViewById<ImageView>(R.id.cameraSwitchButton).setOnClickListener {
            switchCamera()
        }

        // Shutter button
        findViewById<ImageView>(R.id.shutterButton).setOnClickListener {
            takePhoto()
        }

        // Filters button
        findViewById<ImageView>(R.id.filtersButton).setOnClickListener {
            toggleFilters()
        }

        // Close button
        findViewById<ImageView>(R.id.closeButton).setOnClickListener {
            finish()
        }
    }

    private fun setupCameraModes() {
        val modes = listOf("TYPE", "LIVE", "NORMAL", "BOOMERANG", "SUPERZOOM")
        
        findViewById<LinearLayout>(R.id.typeMode).setOnClickListener {
            selectMode("TYPE")
        }
        
        findViewById<LinearLayout>(R.id.liveMode).setOnClickListener {
            selectMode("LIVE")
        }
        
        findViewById<LinearLayout>(R.id.normalMode).setOnClickListener {
            selectMode("NORMAL")
        }
        
        findViewById<LinearLayout>(R.id.boomerangMode).setOnClickListener {
            selectMode("BOOMERANG")
        }
        
        findViewById<LinearLayout>(R.id.superzoomMode).setOnClickListener {
            selectMode("SUPERZOOM")
        }
    }

    private fun toggleFlash() {
        isFlashOn = !isFlashOn
        val flashButton = findViewById<ImageView>(R.id.flashButton)
        
        if (isFlashOn) {
            flashButton.setImageResource(R.drawable.flash_on)
            Toast.makeText(this, "Flash ON", Toast.LENGTH_SHORT).show()
        } else {
            flashButton.setImageResource(R.drawable.flash_off)
            Toast.makeText(this, "Flash OFF", Toast.LENGTH_SHORT).show()
        }
    }

    private fun switchCamera() {
        isFrontCamera = !isFrontCamera
        Toast.makeText(this, if (isFrontCamera) "Switched to front camera" else "Switched to rear camera", Toast.LENGTH_SHORT).show()
    }

    private fun takePhoto() {
        Toast.makeText(this, "Photo captured!", Toast.LENGTH_SHORT).show()
        // Here you would typically capture the photo and navigate to preview/edit screen
    }

    private fun toggleFilters() {
        Toast.makeText(this, "Filters toggled", Toast.LENGTH_SHORT).show()
    }

    private fun selectMode(mode: String) {
        currentMode = mode
        
        // Reset all mode text colors
        findViewById<TextView>(R.id.typeModeText).setTextColor(0x80FFFFFF.toInt())
        findViewById<TextView>(R.id.liveModeText).setTextColor(0x80FFFFFF.toInt())
        findViewById<TextView>(R.id.normalModeText).setTextColor(0x80FFFFFF.toInt())
        findViewById<TextView>(R.id.boomerangModeText).setTextColor(0x80FFFFFF.toInt())
        findViewById<TextView>(R.id.superzoomModeText).setTextColor(0x80FFFFFF.toInt())
        
        // Highlight selected mode
        when (mode) {
            "TYPE" -> findViewById<TextView>(R.id.typeModeText).setTextColor(0xFFFFFFFF.toInt())
            "LIVE" -> findViewById<TextView>(R.id.liveModeText).setTextColor(0xFFFFFFFF.toInt())
            "NORMAL" -> findViewById<TextView>(R.id.normalModeText).setTextColor(0xFFFFFFFF.toInt())
            "BOOMERANG" -> findViewById<TextView>(R.id.boomerangModeText).setTextColor(0xFFFFFFFF.toInt())
            "SUPERZOOM" -> findViewById<TextView>(R.id.superzoomModeText).setTextColor(0xFFFFFFFF.toInt())
        }
        
        Toast.makeText(this, "Mode: $mode", Toast.LENGTH_SHORT).show()
    }
}
