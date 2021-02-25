package com.onurcemkarakoc.movieapp.ui.main.popular

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.onurcemkarakoc.movieapp.R
import com.onurcemkarakoc.movieapp.databinding.FragmentPopularMoviesBinding
import com.onurcemkarakoc.movieapp.ui.main.adapters.MovieAdapter
import com.onurcemkarakoc.movieapp.utils.gone
import com.onurcemkarakoc.movieapp.utils.visible
import org.koin.androidx.viewmodel.ext.android.viewModel

class PopularMoviesFragment : Fragment() {

    companion object {
        fun newInstance(): PopularMoviesFragment {
            return PopularMoviesFragment()
        }
    }

    private var binding:FragmentPopularMoviesBinding?=null

    private val viewModel by viewModel<PopularMoviesViewModel>()


    private lateinit var adapter: MovieAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_popular_movies, container, false)
        return binding?.root!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        adapter = MovieAdapter()

        viewModel.getPopularMovies().observe(viewLifecycleOwner) {
            adapter.submitList(it)
            binding?.popularRc?.adapter = adapter
            binding?.popularRc?.visible()
            binding?.popularProgressbar?.gone()
        }
    }

    override fun onDestroyView() {
        binding=null
        super.onDestroyView()
    }


}
