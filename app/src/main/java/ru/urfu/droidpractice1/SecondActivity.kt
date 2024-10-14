package ru.urfu.droidpractice1

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val articleImage = findViewById<ImageView>(R.id.article_image)
        Glide.with(this)
            .load("https://ixbt.online/gametech/covers/2024/10/14/nova-filepond-4Gpuh6.jpg")
            .into(articleImage)

        val toggleRead = findViewById<ToggleButton>(R.id.toggle_read)
        val backButton = findViewById<Button>(R.id.back_button)

        // Log lifecycle
        Log.d("SecondActivity", "onCreate called")

        toggleRead.setOnCheckedChangeListener { _, isChecked ->
            Log.d("SecondActivity", if (isChecked) "Article read" else "Article unread")
        }

        backButton.setOnClickListener {
            finish() // Go back to the first article
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("SecondActivity", "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("SecondActivity", "onPause called")
    }
}