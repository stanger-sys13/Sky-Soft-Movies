package com.example.skysoftmovies.ui.tablist

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.skysoftmovies.R
import com.example.skysoftmovies.adapter.AdapterListFilmes
import com.example.skysoftmovies.model.Item
import com.example.skysoftmovies.ui.list.ListMoviesActivity

class TabTwoFragment : Fragment() {
    val btnlistmovie by lazy { view?.findViewById<Button>(R.id.btn_list_movie) }

    private var listDeFilmes = mutableListOf<Item>()
    val recycler1 by lazy {view?.findViewById<RecyclerView>(R.id.recycler_list)}

    companion object {
        fun newInstance() = TabTwoFragment()
    }

    private lateinit var viewModel: TabTwoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tab_two, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btnlistmovie?.setOnClickListener {
            val intent = Intent(activity, ListMoviesActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
        }

        viewModel = ViewModelProvider(this).get(TabTwoViewModel::class.java)

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