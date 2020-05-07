package com.onurcemkarakoc.movieapp.ui.main.popular

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.onurcemkarakoc.movieapp.data.remote.ApiService
import com.onurcemkarakoc.movieapp.models.movie.MoviesResults
import com.onurcemkarakoc.movieapp.ui.main.MainRepository
import javax.inject.Inject

class PopularMoviesViewModel(private val apiService: ApiService) : ViewModel() {

    private val repository: MainRepository by lazy { MainRepository(apiService) }

    fun getPopularMovies(): LiveData<List<MoviesResults>> = repository.getPopularMovies()
}