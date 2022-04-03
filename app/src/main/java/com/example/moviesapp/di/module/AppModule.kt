package com.example.moviesapp.di.module

import com.example.moviesapp.network.MovieApi
import com.example.moviesapp.repository.RepositoryImp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Singleton
    @Provides
    fun provideRepositoryImp(movieApi: MovieApi): RepositoryImp = RepositoryImp(movieApi)
}