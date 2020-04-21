package com.onurcemkarakoc.movieapp.ui.main.popular

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.onurcemkarakoc.movieapp.base.BaseVMFragment
import com.onurcemkarakoc.movieapp.ui.main.adapters.MovieAdapter

/**
 * A simple [Fragment] subclass.
 */
class PopularMoviesFragment : BaseVMFragment<PopularMoviesViewModel>() {

    private lateinit var adapter: MovieAdapter

    override fun getViewModel(): Class<PopularMoviesViewModel> = PopularMoviesViewModel::class.java

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_popular_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = MovieAdapter()
        viewModel.getPopularMovies().observe(this, Observer {
            adapter.submitList(it)
            popular_rc.adapter = adapter
            popular_rc.visible()
            popular_progressbar.gone()
        })
    }


}
