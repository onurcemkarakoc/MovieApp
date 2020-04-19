package com.onurcemkarakoc.movieapp.models.reviews


import com.google.gson.annotations.SerializedName

data class MovieReviewResults(
    @SerializedName("author")
    val author: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("url")
    val url: String
)