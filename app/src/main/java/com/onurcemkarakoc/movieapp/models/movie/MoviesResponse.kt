package com.onurcemkarakoc.movieapp.models.movie


import com.google.gson.annotations.SerializedName

data class MoviesResponse(
    @SerializedName("results")
    val results: List<MoviesResults>
)