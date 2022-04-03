package com.example.moviesapp.network

import com.example.moviesapp.model.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface MovieApi {
    @GET("movie/popular")
    suspend fun getUpcomingMovie(@Query("api_key") apiKey: String, @Query("page") page: Int=1): MoviesResponse
}