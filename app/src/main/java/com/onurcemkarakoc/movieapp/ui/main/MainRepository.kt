package com.onurcemkarakoc.movieapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.onurcemkarakoc.movieapp.data.remote.ApiService
import com.onurcemkarakoc.movieapp.models.movie.MoviesResponse
import com.onurcemkarakoc.movieapp.models.movie.MoviesResults
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository(private val apiService: ApiService) {

    private val compositeDisposable = CompositeDisposable()

    fun getPopularMovies(): LiveData<List<MoviesResults>> {
        val moviesLiveData: MutableLiveData<List<MoviesResults>> = MutableLiveData()
        compositeDisposable.add(apiService.getPopularMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                moviesLiveData.value = it.results
            })

        return moviesLiveData
    }

    fun getTopRatedMovies(): LiveData<List<MoviesResults>> {
        val moviesLiveData: MutableLiveData<List<MoviesResults>> = MutableLiveData()
        compositeDisposable.add(apiService.getTopRatedMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                moviesLiveData.value = it.results
            })
        return moviesLiveData
    }

}