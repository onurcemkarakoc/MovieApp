package com.onurcemkarakoc.movieapp.ui.main.toprated

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.onurcemkarakoc.movieapp.R
import com.onurcemkarakoc.movieapp.databinding.FragmentTopRatedMoviesBinding
import com.onurcemkarakoc.movieapp.ui.main.adapters.MovieAdapter
import com.onurcemkarakoc.movieapp.ui.main.popular.PopularMoviesFragment
import com.onurcemkarakoc.movieapp.utils.gone
import com.onurcemkarakoc.movieapp.utils.visible
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
class TopRatedMoviesFragment : Fragment() {
    companion object {
        fun newInstance(): TopRatedMoviesFragment {
            return TopRatedMoviesFragment()
        }
    }
    private lateinit var adapter: MovieAdapter
    private val viewModel by viewModel<TopRatedMoviesViewModel>()
    private var binding : FragmentTopRatedMoviesBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_top_rated_movies, container, false)
        return binding?.root!!
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = MovieAdapter()
        viewModel.getTopRatedMovies().observe(viewLifecycleOwner) {
            binding?.topRatedRc?.adapter = adapter
            adapter.submitList(it)
            binding?.topRatedRc?.visible()
            binding?.topRatedProgressbar?.gone()
        }

    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

}
