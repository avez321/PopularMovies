package com.example.moviesapp.ui.popular_movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.databinding.ItemMovieBinding
import com.example.moviesapp.model.Movie


class PopularMoviesAdapter : RecyclerView.Adapter<PopularMoviesAdapter.ContentViewHolder>() {
    private var movieArrayList: ArrayList<Movie>? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        val movieBinding = DataBindingUtil.inflate<ItemMovieBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_movie,
            parent,
            false
        )

        return ContentViewHolder(movieBinding)
    }

    override fun getItemCount(): Int = movieArrayList?.size ?: 0


    override fun onBindViewHolder(contentViewHolder: ContentViewHolder, position: Int) {
        contentViewHolder.bind(movieArrayList?.get(position))
    }


    fun setData(movieArrayList: ArrayList<Movie>) {
        if(this.movieArrayList==null) {
            this.movieArrayList = movieArrayList
        } else {
            this.movieArrayList?.addAll(movieArrayList)
        }
        notifyDataSetChanged()
    }

    class ContentViewHolder(
        val binding: ItemMovieBinding
    ) : RecyclerView.ViewHolder(binding.root) {


        fun bind(movie: Movie?) {
            binding.movie = movie
        }
    }

}