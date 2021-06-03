package com.example.skysoftmovies.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.skysoftmovies.ProfileActivity
import com.example.skysoftmovies.R

class LoginData : AppCompatActivity() {
    lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_fragment)
        editText = findViewById(R.id.et_user)
    }

    fun onButtonClicked(view: View) {
        val i = Intent(this, ProfileActivity::class.java).apply {
            putExtra("Data",editText.text.toString())
        }

        startActivity(i)
    }

}