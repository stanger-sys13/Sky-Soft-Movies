package com.example.skysoftmovies.ui.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.skysoftmovies.R


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
}