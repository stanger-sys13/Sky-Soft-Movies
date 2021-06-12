package com.example.skysoftmovies.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.skysoftmovies.model.GeneresResponse
import com.example.skysoftmovies.model.Movie
import com.example.skysoftmovies.model.MovieTotalResponse
import com.example.skysoftmovies.repository.RepositoryApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.UnknownHostException

class MainViewModel : ViewModel() {

    val movieLiveData = MutableLiveData<Movie>()
    val genresLiveData = MutableLiveData<GeneresResponse>()
    val movieSimilarLiveData = MutableLiveData<ArrayList<MovieTotalResponse>>()
    val repository = RepositoryApi()
    val loadingFilmes = MutableLiveData<Boolean>()
    val loadingFilmesSky = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()

    fun baseFilmesCoroutines(idFilme: Int){
        CoroutineScope(Dispatchers.IO).launch {
            loadingFilmes.postValue(true)

            try {
                repository.baseFilmeApi(idFilme).let {
                    movieLiveData.postValue(it)
                    loadingFilmes.postValue(false) }
            }

            catch (error: Throwable) {
                loadingFilmes.postValue(false)
                Erroor(error)
            }
        }
    }

    fun baseFilmesSkyCoroutines(idFilme: Int){
        CoroutineScope(Dispatchers.IO).launch {
            loadingFilmesSky.postValue(true)

            try {
                repository.baseFilmesSkyApi(idFilme).let {
                    movieSimilarLiveData.postValue((it.results as ArrayList<MovieTotalResponse>?)!!)
                    loadingFilmesSky.postValue(false) }
            }

            catch (error: Throwable) {
                loadingFilmesSky.postValue(false)
                Erroor(error)
            }
        }
    }

    fun baseGenersCoroutines(){
        CoroutineScope(Dispatchers.IO).launch {

            try {
                repository.baseGenersApi().let {
                    genresLiveData.postValue(it)
                }
            }

            catch (error: Throwable) {
                Erroor(error)
            }
        }
    }

    private fun Erroor(error: Throwable) {
        when(error){
            is UnknownHostException -> errorMessage.postValue("error")
        }
    }
}