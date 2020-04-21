package com.onurcemkarakoc.movieapp.ui.main.toprated

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
class TopRatedMoviesFragment : BaseVMFragment<TopRatedMoviesViewModel>() {

    private lateinit var adapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_top_rated_movies, container, false)
    }

    override fun getViewModel(): Class<TopRatedMoviesViewModel> =
        TopRatedMoviesViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = MovieAdapter()
        viewModel.getTopRatedMovies().observe(this, Observer {
            top_rated_rc.adapter = adapter
            adapter.submitList(it)
            top_rated_rc.visible()
            top_rated_progressbar.gone()
        })

    }

}
