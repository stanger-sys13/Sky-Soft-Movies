package com.example.skysoftmovies.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.skysoftmovies.R


class ViewHolderListFilmes  (view: View) : RecyclerView.ViewHolder(view) {

    val nameFilme by lazy { view.findViewById<TextView>(R.id.recycler_listfilmes_title) }
    val imagemFilme by lazy { view.findViewById<ImageView>(R.id.recycler_listfilmes_imagem) }

}