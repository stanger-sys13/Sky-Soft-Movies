package com.example.skysoftmovies.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.skysoftmovies.R


class ViewHolderFilmes (view: View) : RecyclerView.ViewHolder(view) {

    val nameDoFilmeSky by lazy { view.findViewById<TextView>(R.id.recycler_title_filme) }
    val anoDoFilme by lazy { view.findViewById<TextView>(R.id.recycler_ano_filme) }
    val generDoFilme by lazy { view.findViewById<TextView>(R.id.recycler_gener_filme) }
    val imagemDoFilme by lazy { view.findViewById<ImageView>(R.id.recycler_imagem_filme) }

}
