package com.example.skysoftmovies.model


import com.google.gson.annotations.SerializedName

data class GeneresResponse (

        @SerializedName("genres")
        val listGeners: ArrayList<Gener>
)