package com.example.moviesapp.di.module

import com.example.moviesapp.network.MovieApi
import com.rtr.moviesdemo.model.MoviesClient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideMovieApi(): MovieApi = MoviesClient.makeMovieApi()
}