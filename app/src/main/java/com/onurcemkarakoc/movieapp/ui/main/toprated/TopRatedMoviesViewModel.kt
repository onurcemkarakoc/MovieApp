package com.onurcemkarakoc.movieapp.ui.main.toprated

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.onurcemkarakoc.movieapp.data.remote.ApiService
import com.onurcemkarakoc.movieapp.models.movie.MoviesResults
import com.onurcemkarakoc.movieapp.ui.main.MainRepository

class TopRatedMoviesViewModel(private val repository: MainRepository) : ViewModel() {
    fun getTopRatedMovies(): LiveData<List<MoviesResults>> = repository.getTopRatedMovies()
}