package com.faizan.i221356

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MessagesActivity : AppCompatActivity() {
    
    override fun onStart() {
        super.onStart()
        Log.d("MessagesActivity", "onStart called")
    }
    
    override fun onResume() {
        super.onResume()
        Log.d("MessagesActivity", "onResume called")
        Toast.makeText(this, "MessagesActivity is now visible!", Toast.LENGTH_LONG).show()
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MessagesActivity", "onCreate called - starting MessagesActivity")
        
        try {
            setContentView(R.layout.activity_messages)
            Log.d("MessagesActivity", "Layout set successfully")
        } catch (e: Exception) {
            Log.e("MessagesActivity", "Error setting content view: ${e.message}")
            Toast.makeText(this, "Error loading messages layout: ${e.message}", Toast.LENGTH_LONG).show()
            return
        }

        Log.d("MessagesActivity", "MessagesActivity created successfully")
        Toast.makeText(this, "Welcome to Messages!", Toast.LENGTH_SHORT).show()

        // Set up click listeners for interactive elements
        setupClickListeners()
        
        // Debug: Check if layout elements are found
        val backArrow = findViewById<ImageView>(R.id.backArrow)
        val plusIcon = findViewById<ImageView>(R.id.plusIcon)
        val cameraButton = findViewById<LinearLayout>(R.id.cameraButton)
        val messageItem1 = findViewById<LinearLayout>(R.id.messageItem1)
        val messageItem2 = findViewById<LinearLayout>(R.id.messageItem2)
        val messageItem3 = findViewById<LinearLayout>(R.id.messageItem3)
        
        Log.d("MessagesActivity", "backArrow found: ${backArrow != null}")
        Log.d("MessagesActivity", "plusIcon found: ${plusIcon != null}")
        Log.d("MessagesActivity", "cameraButton found: ${cameraButton != null}")
        Log.d("MessagesActivity", "messageItem1 found: ${messageItem1 != null}")
        Log.d("MessagesActivity", "messageItem2 found: ${messageItem2 != null}")
        Log.d("MessagesActivity", "messageItem3 found: ${messageItem3 != null}")
    }

    private fun setupClickListeners() {
        // Back arrow navigation
        val backArrow: ImageView = findViewById(R.id.backArrow)
        if (backArrow != null) {
            backArrow.setOnClickListener {
                Toast.makeText(this, "Back arrow clicked!", Toast.LENGTH_SHORT).show()
                try {
                    finish()
                    Log.d("MessagesActivity", "Returning to previous page")
                } catch (e: Exception) {
                    Log.e("MessagesActivity", "Error going back: ${e.message}")
                    Toast.makeText(this, "Error going back: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        } else {
            Log.e("MessagesActivity", "Back arrow not found!")
            Toast.makeText(this, "Back arrow not found!", Toast.LENGTH_SHORT).show()
        }

        // Plus icon
        val plusIcon: ImageView = findViewById(R.id.plusIcon)
        if (plusIcon != null) {
            plusIcon.setOnClickListener {
                Toast.makeText(this, "Plus icon clicked!", Toast.LENGTH_SHORT).show()
                Toast.makeText(this, "New message feature coming soon!", Toast.LENGTH_SHORT).show()
            }
        } else {
            Log.e("MessagesActivity", "Plus icon not found!")
            Toast.makeText(this, "Plus icon not found!", Toast.LENGTH_SHORT).show()
        }

        // Camera button
        val cameraButton: LinearLayout = findViewById(R.id.cameraButton)
        if (cameraButton != null) {
            cameraButton.setOnClickListener {
                Toast.makeText(this, "Camera button clicked!", Toast.LENGTH_SHORT).show()
                Toast.makeText(this, "Camera feature coming soon!", Toast.LENGTH_SHORT).show()
            }
        } else {
            Log.e("MessagesActivity", "Camera button not found!")
            Toast.makeText(this, "Camera button not found!", Toast.LENGTH_SHORT).show()
        }

        // Message Item 1 - ali_ahmed
        val messageItem1: LinearLayout = findViewById(R.id.messageItem1)
        if (messageItem1 != null) {
            messageItem1.setOnClickListener {
                Toast.makeText(this, "Opening chat with ali_ahmed", Toast.LENGTH_SHORT).show()
                try {
                    val intent = Intent(this, DirectMessageActivity::class.java)
                    startActivity(intent)
                    Log.d("MessagesActivity", "Navigating to DirectMessageActivity for ali_ahmed")
                } catch (e: Exception) {
                    Log.e("MessagesActivity", "Error navigating to DirectMessageActivity: ${e.message}")
                    Toast.makeText(this, "Error opening chat: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        } else {
            Log.e("MessagesActivity", "Message item 1 not found!")
        }

        // Message Item 2 - sarah_khan
        val messageItem2: LinearLayout = findViewById(R.id.messageItem2)
        if (messageItem2 != null) {
            messageItem2.setOnClickListener {
                Toast.makeText(this, "Opening chat with sarah_khan", Toast.LENGTH_SHORT).show()
                try {
                    val intent = Intent(this, DirectMessageActivity::class.java)
                    startActivity(intent)
                    Log.d("MessagesActivity", "Navigating to DirectMessageActivity for sarah_khan")
                } catch (e: Exception) {
                    Log.e("MessagesActivity", "Error navigating to DirectMessageActivity: ${e.message}")
                    Toast.makeText(this, "Error opening chat: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        } else {
            Log.e("MessagesActivity", "Message item 2 not found!")
        }

        // Message Item 3 - mike_wilson
        val messageItem3: LinearLayout = findViewById(R.id.messageItem3)
        if (messageItem3 != null) {
            messageItem3.setOnClickListener {
                Toast.makeText(this, "Opening chat with mike_wilson", Toast.LENGTH_SHORT).show()
                try {
                    val intent = Intent(this, DirectMessageActivity::class.java)
                    startActivity(intent)
                    Log.d("MessagesActivity", "Navigating to DirectMessageActivity for mike_wilson")
                } catch (e: Exception) {
                    Log.e("MessagesActivity", "Error navigating to DirectMessageActivity: ${e.message}")
                    Toast.makeText(this, "Error opening chat: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        } else {
            Log.e("MessagesActivity", "Message item 3 not found!")
        }
    }
}
