package com.onurcemkarakoc.movieapp.ui.main.toprated

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.onurcemkarakoc.movieapp.models.movie.MoviesResults
import com.onurcemkarakoc.movieapp.ui.main.MainRepository

class TopRatedMoviesViewModel : ViewModel() {
    private val mMainRepository: MainRepository by lazy { MainRepository() }

    fun getTopRatedMovies(): LiveData<List<MoviesResults>> = mMainRepository.getTopRatedMovies()
}