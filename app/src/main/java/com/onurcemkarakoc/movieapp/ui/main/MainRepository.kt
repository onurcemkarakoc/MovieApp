package com.onurcemkarakoc.movieapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.onurcemkarakoc.movieapp.data.remote.ApiService
import com.onurcemkarakoc.movieapp.models.movie.MoviesResponse
import com.onurcemkarakoc.movieapp.models.movie.MoviesResults
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository (private val apiService: ApiService) {

    fun getPopularMovies(): LiveData<List<MoviesResults>> {
        val moviesLiveData: MutableLiveData<List<MoviesResults>> = MutableLiveData()
        apiService.getPopularMovies().enqueue(object : Callback<MoviesResponse> {
            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                println("getPopularMovies error ${t.message}")
            }

            override fun onResponse(
                call: Call<MoviesResponse>,
                response: Response<MoviesResponse>
            ) {
                moviesLiveData.value = response.body()?.results
            }

        })
        return moviesLiveData
    }

    fun getTopRatedMovies(): LiveData<List<MoviesResults>> {
        val moviesLiveData: MutableLiveData<List<MoviesResults>> = MutableLiveData()
        apiService.getTopRatedMovies().enqueue(object : Callback<MoviesResponse> {
            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                println("getTopRatedMovies error ${t.message}")
            }

            override fun onResponse(
                call: Call<MoviesResponse>,
                response: Response<MoviesResponse>
            ) {
                moviesLiveData.value = response.body()?.results
            }

        })
        return moviesLiveData
    }

}