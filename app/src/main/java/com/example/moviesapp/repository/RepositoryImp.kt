package com.example.moviesapp.repository


import com.example.moviesapp.Constants
import com.example.moviesapp.network.ResultWrapper
import com.example.moviesapp.network.safeApiCall
import com.example.moviesapp.model.MoviesResponse
import com.example.moviesapp.network.MovieApi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class RepositoryImp(private val movieApi: MovieApi, private val dispatcher: CoroutineDispatcher = Dispatchers.IO) :
    RepositoryInterface {
    override suspend fun getMovies( page:Int): ResultWrapper<MoviesResponse> {

        return safeApiCall(dispatcher) { movieApi.getUpcomingMovie(Constants.apiKey, page ) }
    }
}


