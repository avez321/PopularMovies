package com.example.moviesapp.ui.popular_movies

import PaginationListener
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.MoviesApp
import com.example.moviesapp.R
import com.example.moviesapp.databinding.FragmentMovieListBinding
import javax.inject.Inject


class PopularMoviesFragment : Fragment() {
    private lateinit var fragmentMovieListBinding: FragmentMovieListBinding
    @Inject lateinit var popularMoviesViewModel: PopularMoviesViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val moviesApp = requireActivity().application as MoviesApp
        moviesApp.appComponent.inject(this)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requireActivity().setTitle(R.string.popular_movies)
        fragmentMovieListBinding =  FragmentMovieListBinding.inflate(inflater)
        fragmentMovieListBinding.viewmodel = popularMoviesViewModel
        initRecycleView()
        popularMoviesViewModel.getMoviesData()
        return fragmentMovieListBinding.root
    }


    private fun initRecycleView() {
        val adapter = PopularMoviesAdapter()

        fragmentMovieListBinding.rvUpcomingMovies.adapter = adapter

        val linearLayoutManager = LinearLayoutManager(context)

        fragmentMovieListBinding.rvUpcomingMovies.layoutManager = linearLayoutManager

        fragmentMovieListBinding.rvUpcomingMovies.addOnScrollListener(object :
            RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    popularMoviesViewModel.getMoviesData()
                }
            }
        })
    }
}


