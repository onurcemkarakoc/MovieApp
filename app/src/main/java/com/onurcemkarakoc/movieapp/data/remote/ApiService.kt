package com.onurcemkarakoc.movieapp.data.remote

import com.onurcemkarakoc.movieapp.models.detail.MovieDetailResponse
import com.onurcemkarakoc.movieapp.models.movie.MoviesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("movie/popular")
    fun getPopularMovies(): Call<MoviesResponse>

    @GET("movie/top_rated")
    fun getTopRatedMovies(): Call<MoviesResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetail(@Path("movie_id") movie_id: Int): Call<MovieDetailResponse>

    @GET("movie/{movie_id}/videos")
    fun getMovieVideos(): Call<MoviesResponse>

    @GET("movie/{movie_id}/reviews")
    fun getMovieReviews(): Call<MoviesResponse>
}