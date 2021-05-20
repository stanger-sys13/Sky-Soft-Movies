package com.example.skysoftmovies.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.skysoftmovies.R
import com.example.skysoftmovies.adapter.AdapterFilmesSky
import com.example.skysoftmovies.model.Gener
import com.example.skysoftmovies.model.MovieTotalResponse
import com.squareup.picasso.Picasso

class MainFragment(private val idFilme: Int) : Fragment() {

    val titleFilme by lazy {view?.findViewById<TextView>(R.id.tv_title)}
    val imagemFilme by lazy { view?.findViewById<ImageView>(R.id.iv_filme) }
    val viewsFilme by lazy { view?.findViewById<TextView>(R.id.tv_likes) }
    val likesFilmes by lazy { view?.findViewById<TextView>(R.id.tv_likeview) }
    val emptyHeart by lazy {view?.findViewById<ImageView>(R.id.iv_emptyheart)}
    val filledHeart by lazy {view?.findViewById<ImageView>(R.id.iv_filed_heart)}
    val buttonReturn by lazy {view?.findViewById<Button>(R.id.btn_return)}

    val recycler by lazy {view?.findViewById<RecyclerView>(R.id.recycler_main)}
    private var listFilmeSimilar = mutableListOf<MovieTotalResponse>()

    private var listGeners = mutableListOf<Gener>()

    lateinit var progressBarFilmes : ProgressBar
    lateinit var progressBarFilmesSky : ProgressBar

    companion object {
        fun newInstance(idFilme: Int) = MainFragment(idFilme)
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        progressBarFilmes = view!!.findViewById<ProgressBar>(R.id.progress_bar_filmes)
        progressBarFilmesSky = view!!.findViewById<ProgressBar>(R.id.progress_bar_filmes_sky)

        buttonReturn?.setOnClickListener {
            activity?.onBackPressed()
        }

        viewModel.baseFilmesCoroutines(idFilme)
        viewModel.movieLiveData.observe(this, Observer {

            val baseUrlImage = "https://image.tmdb.org/t/p/"
            val tamanhoImage = "w500/"

            titleFilme?.text = it.originalTitle
            viewsFilme?.text = it.voteCount.toString()
            likesFilmes?.text = it.popularity.toString()

            Picasso.with(activity).load(baseUrlImage + tamanhoImage + it.posterPath).fit().into(imagemFilme)

            setClickListeners()

        })

        recycler?.layoutManager = LinearLayoutManager(activity)

        viewModel.baseGenersCoroutines()
        viewModel.genresLiveData.observe(this, Observer {
            listGeners.addAll(it.listGeners)

            viewModel.baseFilmesSkyCoroutines(idFilme)
        })

        viewModel.movieSimilarLiveData.observe(this, Observer {
            listFilmeSimilar.addAll(it)

            val adapter = activity?.let { AdapterFilmesSky(listFilmeSimilar, it, listGeners) }
            recycler?.adapter = adapter

            adapter?.notifyDataSetChanged()

        })

        viewModel.loadingFilmes.observe(this, Observer {
            if (it) {
                progressBarFilmes.visibility = View.VISIBLE
            } else {
                progressBarFilmes.visibility = View.GONE
            }
        })

        viewModel.loadingFilmesSky.observe(this, Observer {
            if (it) {
                progressBarFilmesSky.visibility = View.VISIBLE
            } else {
                progressBarFilmesSky.visibility = View.GONE
            }
        })

        viewModel.errorMessage.observe(this, Observer {
            Toast.makeText(activity, it, Toast.LENGTH_SHORT).show()
        })

    }

    fun setClickListeners(){
        emptyHeart?.setOnClickListener {
            filledHeart?.visibility = View.VISIBLE
        }

        filledHeart?.setOnClickListener {
            filledHeart?.visibility = View.GONE
        }
    }
}