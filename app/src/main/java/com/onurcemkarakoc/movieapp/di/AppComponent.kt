package com.onurcemkarakoc.movieapp.di

import com.onurcemkarakoc.movieapp.ui.main.MainActivity
import com.onurcemkarakoc.movieapp.ui.main.popular.PopularMoviesFragment
import com.onurcemkarakoc.movieapp.ui.main.toprated.TopRatedMoviesFragment
import com.onurcemkarakoc.movieapp.ui.main.toprated.TopRatedMoviesViewModel
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent{
    fun inject(mainActivity: MainActivity)
    fun inject(fragmentTopRatedMoviesFragment: TopRatedMoviesFragment)
    fun inject(fragmentPopularMoviesFragment: PopularMoviesFragment)
}