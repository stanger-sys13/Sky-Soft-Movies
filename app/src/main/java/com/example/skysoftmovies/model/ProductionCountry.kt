package com.example.skysoftmovies.model

import com.google.gson.annotations.SerializedName

data class ProductionCountry(

        @SerializedName("iso_3166_11")
    val iso31661: String?,

        @SerializedName("name")
    val name: String?
)