package com.onurcemkarakoc.movieapp.models.reviews


import com.google.gson.annotations.SerializedName

data class MovieReviewsResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("results")
    val results: List<MovieReviewResults>
)