package com.onurcemkarakoc.movieapp.ui.main.toprated

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.onurcemkarakoc.movieapp.R
import com.onurcemkarakoc.movieapp.base.BaseVMFragment
import com.onurcemkarakoc.movieapp.data.remote.ApiService
import com.onurcemkarakoc.movieapp.di.DaggerAppComponent
import com.onurcemkarakoc.movieapp.ui.main.adapters.MovieAdapter
import com.onurcemkarakoc.movieapp.ui.main.popular.PopularMoviesViewModel
import com.onurcemkarakoc.movieapp.utils.gone
import com.onurcemkarakoc.movieapp.utils.visible
import kotlinx.android.synthetic.main.fragment_top_rated_movies.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class TopRatedMoviesFragment()  : Fragment() {

    private lateinit var adapter: MovieAdapter
    private lateinit var viewModel:TopRatedMoviesViewModel

    @Inject
    lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerAppComponent.builder().build().inject(this)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_top_rated_movies, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = TopRatedMoviesViewModel(apiService)
        adapter = MovieAdapter()
        viewModel.getTopRatedMovies().observe(this, Observer {
            top_rated_rc.adapter = adapter
            adapter.submitList(it)
            top_rated_rc.visible()
            top_rated_progressbar.gone()
        })

    }

}
