package com.example.socialsparkapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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

        // linking UI elements
        val inputTime = findViewById<EditText>(R.id.editTextTime)
        val resultText = findViewById<TextView>(R.id.txtResult)
        val btnSuggest = findViewById<Button>(R.id.btnSuggest)
        val btnReset = findViewById<Button>(R.id.btnReset)

        // when user clicks suggest button
        btnSuggest.setOnClickListener {

            val userInput = inputTime.text.toString().trim().lowercase()

            // log input User input
            Log.d("USER_INPUT", userInput)

            if (userInput.isEmpty()) {
                resultText.text = "Please enter a time of day"
            }
            else if (userInput == "morning") {
                resultText.text = "Send a good morning message to a family member"
            }
            else if (userInput == "mid-morning") {
                resultText.text = "Say thank you to a colleague"
            }
            else if (userInput == "afternoon") {
                resultText.text = "Share a funny meme or link with a friend"
            }
            else if (userInput == "afternoon snack time") {
                resultText.text = "Send a quick thinking of you message"
            }
            else if (userInput == "dinner time") {
                resultText.text = "Call someone for a short catch-up"
            }
            else if (userInput == "night" || userInput == "after dinner") {
                resultText.text = "Leave a nice comment on a friend's post"
            }
            else {
                resultText.text = "Invalid input. Try Morning, Afternoon or Night"
            }
        }

        // reset button clears everything
        btnReset.setOnClickListener {
            inputTime.text.clear()
            resultText.text = ""
        }
    }
}