package com.example.skysoftmovies.model

import com.google.gson.annotations.SerializedName

data class Gener(
        @SerializedName("id")
    val id: Int?,

        @SerializedName("name")
    val name: String?
)