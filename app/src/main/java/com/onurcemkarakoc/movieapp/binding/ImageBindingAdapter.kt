package com.onurcemkarakoc.movieapp.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter

object ImageBindingAdapter {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun loadImage(view: ImageView, url: String) {
        if (url.isNotEmpty()) {
            Glide.with(view.context)
                .load(Constant.IMAGE_BASE_URL + Constant.IMAGE_W342 + url)
                .into(view)
        }
    }
}