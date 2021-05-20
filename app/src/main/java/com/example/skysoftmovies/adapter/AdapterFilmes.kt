package com.example.skysoftmovies.adapter

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.skysoftmovies.R
import com.example.skysoftmovies.model.Gener
import com.example.skysoftmovies.model.MovieTotalResponse
import com.squareup.picasso.Picasso
import java.time.LocalDate

class AdapterFilmesSky(
    private val listFilmesSky: MutableList<MovieTotalResponse>,
    private val context: Context,
    private val listGeners: MutableList<Gener>
): RecyclerView.Adapter<ViewHolderFilmes>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderFilmes {
        val view = LayoutInflater.from(context).inflate(R.layout.main_recycler_movies, parent, false)
        return ViewHolderFilmes(view)
    }

    override fun getItemCount(): Int = listFilmesSky.size

    override fun onBindViewHolder(holder: ViewHolderFilmes, position: Int) {
        val nameFilmeSky = holder.nameDoFilmeSky
        nameFilmeSky.text = listFilmesSky[position].title.toString()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val dateComplete = LocalDate.parse(listFilmesSky[position].releaseDate)
            val year = dateComplete.year

            val anoFilmeSemelhante = holder.anoDoFilme
            anoFilmeSemelhante.text = year.toString()
        }

        val priGener = listFilmesSky[position].genreIds?.get(0) ?: 0
        val secGener = listFilmesSky[position].genreIds?.get(1) ?: 0


        val firstGenre = listGeners.firstOrNull {
            it.id == priGener
        }

        val secondGenre = listGeners.firstOrNull {
            it.id == secGener
        }

        firstGenre?.let {gener1 ->

            val genersFilmeSky = holder.generDoFilme
            genersFilmeSky.text = gener1.name

            secondGenre?.let {gener2 ->
                genersFilmeSky.text = gener1.name + ", " + gener2.name
            }

        }

        val baseUrl = "https://image.tmdb.org/t/p/"
        val sizeImage = "w500/"

        val imagemFilmeSky = holder.imagemDoFilme
        Picasso.with(context).load(baseUrl + sizeImage + listFilmesSky[position].posterPath).fit().centerCrop().into(imagemFilmeSky)
    }
}
