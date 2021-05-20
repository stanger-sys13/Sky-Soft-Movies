package com.example.skysoftmovies.network


import com.example.skysoftmovies.model.GeneresResponse
import com.example.skysoftmovies.model.ListFilmes
import com.example.skysoftmovies.model.Movie
import com.example.skysoftmovies.model.MovieTotal
import retrofit2.http.GET
import retrofit2.http.Path

interface EndPoints {

    @GET("movie/{movie_id}")
    suspend fun baseFilmes(
        @Path("movie_id") movie_id: Int
    ): Movie

    @GET("movie/{movie_id}/similar")
    suspend fun baseFilmesSky(
        @Path("movie_id") movie_id: Int
    ): MovieTotal

    @GET("genre/movie/list")
    suspend fun baseGeners(
    ): GeneresResponse

    @GET("list/{list_id}")
    suspend fun baseListDeFilmes(
        @Path("list_id") list_id: Int
    ): ListFilmes

}