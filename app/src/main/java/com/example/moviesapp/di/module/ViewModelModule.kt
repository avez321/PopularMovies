package com.example.moviesapp.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviesapp.di.factory.ViewModelFactory
import com.example.moviesapp.di.ViewModelKey
import com.example.moviesapp.di.scope.FragmentScoped
import com.example.moviesapp.ui.popular_movies.PopularMoviesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory


    @Binds
    @IntoMap
    @FragmentScoped
    @ViewModelKey(PopularMoviesViewModel::class)
    abstract fun bindRegisterViewModel(viewModel: PopularMoviesViewModel): ViewModel
}