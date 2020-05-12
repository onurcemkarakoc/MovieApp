package com.onurcemkarakoc.movieapp.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.onurcemkarakoc.movieapp.R
import com.onurcemkarakoc.movieapp.adapters.MainViewPagerAdapter
import com.onurcemkarakoc.movieapp.data.remote.ApiService
import com.onurcemkarakoc.movieapp.di.DaggerAppComponent
import com.onurcemkarakoc.movieapp.di.NetworkModule
import com.onurcemkarakoc.movieapp.ui.main.popular.PopularMoviesFragment
import com.onurcemkarakoc.movieapp.ui.main.toprated.TopRatedMoviesFragment
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    internal lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerAppComponent
            .builder()
            .build()
            .inject(this)

        setUpUi()


    }

    private fun setUpUi() {
        setSupportActionBar(main_toolbar)
        setUpViewPager()
        main_tabs.setupWithViewPager(main_viewpager)
    }


    private fun setUpViewPager() {
        val adapter = MainViewPagerAdapter(supportFragmentManager)
        adapter.apply {
            addFragment(PopularMoviesFragment(), "Popular")
            addFragment(TopRatedMoviesFragment(), "Top Rated")
        }
        main_viewpager.adapter = adapter
    }
}
