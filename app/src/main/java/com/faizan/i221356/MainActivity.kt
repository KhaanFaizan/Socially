package com.faizan.i221356

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Load the logo image into ImageView
        val imageView: ImageView = findViewById(R.id.logoImageView)
        imageView.setImageResource(R.drawable.socially_logo)

        Log.d("MainActivity", "Starting 5-second timer...")
        
        // Auto-navigate to login page after 5 seconds
        Handler(Looper.getMainLooper()).postDelayed({
            Log.d("MainActivity", "Timer completed, navigating to LoginActivity...")
            try {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                Log.d("MainActivity", "Successfully started LoginActivity")
                finish() // Close the splash screen
            } catch (e: Exception) {
                Log.e("MainActivity", "Error starting LoginActivity", e)
                e.printStackTrace()
                // If there's an error, just finish the activity
                finish()
            }
        }, 5000) // 5000 milliseconds = 5 seconds
    }
}
