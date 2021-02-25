package com.onurcemkarakoc.movieapp.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.onurcemkarakoc.movieapp.R
import com.onurcemkarakoc.movieapp.adapters.MainViewPagerAdapter
import com.onurcemkarakoc.movieapp.databinding.ActivityMainBinding
import com.onurcemkarakoc.movieapp.ui.main.popular.PopularMoviesFragment
import com.onurcemkarakoc.movieapp.ui.main.toprated.TopRatedMoviesFragment

class MainActivity : AppCompatActivity() {

    var binding : ActivityMainBinding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        setUpUi()
    }

    private fun setUpUi() {
        setSupportActionBar(binding?.mainToolbar)
        setUpViewPager()
        binding?.mainTabs?.setupWithViewPager(binding?.mainViewpager)
    }


    private fun setUpViewPager() {
        val adapter = MainViewPagerAdapter(supportFragmentManager)
        adapter.apply {
            addFragment( PopularMoviesFragment.newInstance(), "Popular")
            addFragment(TopRatedMoviesFragment.newInstance(), "Top Rated")
        }
        binding?.mainViewpager?.adapter = adapter
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}
