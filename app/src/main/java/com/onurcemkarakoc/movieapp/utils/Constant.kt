package com.onurcemkarakoc.movieapp.utils

import androidx.recyclerview.widget.DiffUtil
import com.onurcemkarakoc.movieapp.models.movie.MoviesResults

object Constant {
    const val API_KEY = "311fd07aadd7bb818871bee2eaeb58dc"
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/"
    const val IMAGE_W92 = "w92"
    const val IMAGE_W154 = "w154"
    const val IMAGE_W185 = "w185"
    const val IMAGE_W342 = "w342"
    const val IMAGE_W500 = "w500"
    const val IMAGE_W780 = "w780"

    val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MoviesResults>() {
        override fun areItemsTheSame(oldItem: MoviesResults, newItem: MoviesResults): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: MoviesResults,
            newItem: MoviesResults
        ): Boolean = oldItem.originalTitle == newItem.originalTitle

    }
}