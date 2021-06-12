package com.example.skysoftmovies

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.skysoftmovies.db.modelorient.User
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        //fetching user details from intent object
        val UserDetials = intent.getSerializableExtra("UserDetials") as? User


        LoginView.text = UserDetials?.mobillogin


    }

}