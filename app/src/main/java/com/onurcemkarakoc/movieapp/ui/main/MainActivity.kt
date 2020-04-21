package com.onurcemkarakoc.movieapp.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
