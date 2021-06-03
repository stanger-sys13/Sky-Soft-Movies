package com.example.skysoftmovies

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val intentValue = intent.getStringExtra("Data")
        findViewById<TextView>(R.id.LoginView).apply{
            text = intentValue.toString()
        }
    }

}