package com.example.moviesapp.di.module

import android.app.Application
import com.example.moviesapp.database.MoviesDatabase
import com.example.moviesapp.database.MoviesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DataBaseModule {
    @Singleton
    @Provides
    fun provideMoviesRepository(application: Application): MoviesRepository{
       val moviesDao = MoviesDatabase.getDatabase(application).moviesDao()
        return MoviesRepository(moviesDao)
    }
}