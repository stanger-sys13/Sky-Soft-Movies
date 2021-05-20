package com.example.skysoftmovies.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.skysoftmovies.R
import com.example.skysoftmovies.MainActivity

import com.example.skysoftmovies.model.Item
import com.squareup.picasso.Picasso


class AdapterListFilmes (
    private val listFilmes: MutableList<Item>,
    private val context: Context
): RecyclerView.Adapter<ViewHolderListFilmes>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderListFilmes {
        val view = LayoutInflater.from(context).inflate(R.layout.main_recycler_listfilmes, parent, false)
        return ViewHolderListFilmes(view)
    }

    override fun getItemCount(): Int = listFilmes.size

    override fun onBindViewHolder(holder: ViewHolderListFilmes, position: Int) {

        val nameDoFilme = holder.nameFilme
        nameDoFilme.text = listFilmes[position].title.toString()

        val baseUrl = "https://image.tmdb.org/t/p/"
        val sizeImage = "w500/"

        val imagemFilme = holder.imagemFilme
        Picasso.with(context).load(baseUrl + sizeImage + listFilmes[position].posterPath).fit().into(imagemFilme)

        holder.itemView.setOnClickListener {
            val intent = Intent (it.context, MainActivity::class.java)

            intent.putExtra("Sky Filmes", listFilmes[position])

            it.context.startActivity(intent)
        }
    }
}