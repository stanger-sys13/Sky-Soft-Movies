package com.example.skysoftmovies.model

import com.google.gson.annotations.SerializedName

data class MovieTotal(

        @SerializedName("page")
    val page: Int?,

        @SerializedName("results")
    val results: List<MovieTotalResponse>?,

        @SerializedName("total_pages")
    val totalPages: Int?,

        @SerializedName("total_results")
    val totalResults: Int?
)