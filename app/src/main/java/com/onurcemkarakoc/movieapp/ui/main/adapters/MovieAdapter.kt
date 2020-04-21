package com.onurcemkarakoc.movieapp.ui.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.onurcemkarakoc.movieapp.databinding.ItemMovieBinding
import com.onurcemkarakoc.movieapp.models.movie.MoviesResults

class MovieAdapter : ListAdapter<MoviesResults, MovieAdapter.MyViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder.create(
            LayoutInflater.from(parent.context), parent
        )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) =
        holder.bind(getItem(position))

    class MyViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun create(inflater: LayoutInflater, parent: ViewGroup): MyViewHolder =
                MyViewHolder(ItemMovieBinding.inflate(inflater, parent, false))
        }

        fun bind(moviesResults: MoviesResults) {
            binding.movie = moviesResults
            binding.executePendingBindings()
        }
    }

    companion object {

    }
}