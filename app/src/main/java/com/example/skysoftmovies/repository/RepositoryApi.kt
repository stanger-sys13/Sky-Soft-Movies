package com.example.skysoftmovies.repository

import com.example.skysoftmovies.model.GeneresResponse
import com.example.skysoftmovies.model.ListFilmes
import com.example.skysoftmovies.model.Movie
import com.example.skysoftmovies.model.MovieTotal
import com.example.skysoftmovies.network.EndPoints
import com.example.skysoftmovies.network.RetrofitInit

class RepositoryApi {

    companion object{
        const val key = "a49cf8a5f42225880f049917a2262e81"
    }

    private var url = "https://api.themoviedb.org/3/"

    private var service = EndPoints::class

    private val conectionService = RetrofitInit(url).create(service)

    suspend fun baseFilmeApi(idFilme: Int): Movie = conectionService.baseFilmes(idFilme)

    suspend fun baseFilmesSkyApi(idFilme: Int): MovieTotal = conectionService.baseFilmesSky(idFilme)

    suspend fun baseGenersApi(): GeneresResponse = conectionService.baseGeners()

    suspend fun baseListDeFilmesApi(): ListFilmes = conectionService.baseListDeFilmes(1)
}


