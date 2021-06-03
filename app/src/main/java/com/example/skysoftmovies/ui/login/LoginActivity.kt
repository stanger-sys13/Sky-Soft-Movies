package com.example.skysoftmovies.ui.login

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.skysoftmovies.R


class LoginActivity : AppCompatActivity() {
    //valid email
    fun isValidString(str: String): Boolean{
        return android.util.Patterns.EMAIL_ADDRESS.matcher(str).matches()
    }
    //

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        ///valid email
        val emails = arrayOf<String>("hello@gmail.com", "one.com")

        emails.forEach {
            Log.d("LoginActivity","is valid email $it => ${isValidString(it)}")
        }
        ///
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container_login,
                    LoginFragment.newInstance()
                )
                .commitNow()
        }

    }

}
