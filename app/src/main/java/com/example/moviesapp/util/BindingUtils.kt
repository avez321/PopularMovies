package com.example.moviesapp.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.moviesapp.R
import com.example.moviesapp.model.Result
import com.example.moviesapp.ui.popular_movies.PopularMoviesAdapter


object BindingUtils {
    @JvmStatic
    @BindingAdapter("android:imageUrl")
    fun setImageUrl(imageView: ImageView, url: String?) {
        Glide
            .with(imageView.context)
            .load("https://image.tmdb.org/t/p/w200/" + url)
            .placeholder(R.drawable.loading_wait_time)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .into(imageView);
    }

    @JvmStatic
    @BindingAdapter("android:moviesData")
    fun setData(recyclerView: RecyclerView, movieArrayList: ArrayList<Result>?) {
        movieArrayList?.let {
            val movieAdapter = recyclerView.adapter as PopularMoviesAdapter
            movieAdapter.setData(it)
        }
    }
 }

