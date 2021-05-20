package com.example.skysoftmovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.skysoftmovies.R
import com.example.skysoftmovies.model.Item
import com.example.skysoftmovies.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val inform = intent.extras
        val filme = inform?.getSerializable("Sky Filmes") as Item

        if (savedInstanceState == null) {
            filme.id?.let { MainFragment.newInstance(it) }?.let {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, it)
                    .commitNow()
            }
        }
    }
}
