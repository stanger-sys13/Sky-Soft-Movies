package com.example.skysoftmovies.ui.register

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.skysoftmovies.R

class ActivityRegister : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.container_register,
                    RegisterFragment.newInstance()
                )
                .commitNow()
        }

    }

}