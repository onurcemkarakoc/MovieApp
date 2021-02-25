package com.onurcemkarakoc.movieapp.ui.main.popular

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.onurcemkarakoc.movieapp.models.movie.MoviesResults
import com.onurcemkarakoc.movieapp.ui.main.MainRepository

class PopularMoviesViewModel(private val repository: MainRepository) : ViewModel() {
    fun getPopularMovies(): LiveData<List<MoviesResults>> = repository.getPopularMovies()
}