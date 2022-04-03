package com.example.moviesapp.repository

import com.example.moviesapp.model.MoviesResponse
import com.example.moviesapp.network.ResultWrapper

interface RepositoryInterface {
   suspend fun getMovies(page:Int): ResultWrapper<MoviesResponse>
}