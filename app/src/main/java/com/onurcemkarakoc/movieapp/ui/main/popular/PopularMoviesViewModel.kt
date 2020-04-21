package com.onurcemkarakoc.movieapp.ui.main.popular

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.onurcemkarakoc.movieapp.models.movie.MoviesResults
import com.onurcemkarakoc.movieapp.ui.main.MainRepository

class PopularMoviesViewModel : ViewModel() {

    private val repository: MainRepository by lazy { MainRepository() }

    fun getPopularMovies(): LiveData<List<MoviesResults>> = repository.getPopularMovies()
}