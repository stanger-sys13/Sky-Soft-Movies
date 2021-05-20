package com.example.skysoftmovies.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.skysoftmovies.R


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container_login,
                    LoginFragment.newInstance()
                )
                .commitNow()
        }
    }
}