package com.onurcemkarakoc.movieapp.ui.main.popular

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.onurcemkarakoc.movieapp.R
import com.onurcemkarakoc.movieapp.base.BaseVMFragment
import com.onurcemkarakoc.movieapp.data.remote.ApiService
import com.onurcemkarakoc.movieapp.ui.main.adapters.MovieAdapter
import com.onurcemkarakoc.movieapp.utils.gone
import com.onurcemkarakoc.movieapp.utils.visible
import kotlinx.android.synthetic.main.fragment_popular_movies.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class PopularMoviesFragment (private val apiService: ApiService) : Fragment() {

    private lateinit var adapter: MovieAdapter
    private lateinit var viewModel: PopularMoviesViewModel

   // override fun getViewModel(): Class<PopularMoviesViewModel> = PopularMoviesViewModel::class.java

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_popular_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel = PopularMoviesViewModel(apiService )
        adapter = MovieAdapter()
        viewModel.getPopularMovies().observe(this, Observer {
            adapter.submitList(it)
            popular_rc.adapter = adapter
            popular_rc.visible()
            popular_progressbar.gone()
        })
    }


}
