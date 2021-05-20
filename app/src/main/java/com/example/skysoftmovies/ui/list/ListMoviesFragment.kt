package com.example.skysoftmovies.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.skysoftmovies.R

import com.example.skysoftmovies.adapter.AdapterListFilmes
import com.example.skysoftmovies.model.Item

class ListMoviesFragment : Fragment() {

    private var listDeFilmes = mutableListOf<Item>()
    val recycler1 by lazy {view?.findViewById<RecyclerView>(R.id.recycler_list)}

    companion object {
        fun newInstance() = ListMoviesFragment()
    }

    private lateinit var viewModel: ListMoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_movies, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(ListMoviesViewModel::class.java)

        viewModel.baseListDeFilmesCoroutines()

        recycler1?.layoutManager = LinearLayoutManager(activity)

        viewModel.listFilmesLiveData.observe(this, Observer {
            it.items?.let { it1 -> listDeFilmes.addAll(it1) }

            val adapter = activity?.let { AdapterListFilmes(listDeFilmes, it) }
            recycler1?.adapter = adapter

            listDeFilmes

            adapter?.notifyDataSetChanged()

        })
    }
}