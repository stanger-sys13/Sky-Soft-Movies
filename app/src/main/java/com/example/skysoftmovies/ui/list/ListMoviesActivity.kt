package com.example.skysoftmovies.ui.list

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.skysoftmovies.ProfileActivity
import com.example.skysoftmovies.R
import com.example.skysoftmovies.ui.login.LoginActivity


class ListMoviesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_movies)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ListMoviesFragment.newInstance())
                .commitNow()
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.layout.nav_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId


        if (id == R.id.profile) {

            val intent = Intent(this, ProfileActivity::class.java)
            this.startActivity(intent)
            return true
        }

        if (id == R.id.logout) {

            val intent = Intent(this, LoginActivity::class.java)
            this.startActivity(intent)
            return true
        }



        return super.onOptionsItemSelected(item)

    }

}