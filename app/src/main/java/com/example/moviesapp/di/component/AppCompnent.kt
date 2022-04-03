package com.example.moviesapp.di.component


import android.app.Application
import com.example.moviesapp.di.module.AppModule
import com.example.moviesapp.di.module.DataBaseModule
import com.example.moviesapp.di.module.NetworkModule
import com.example.moviesapp.di.module.ViewModelModule
import com.example.moviesapp.ui.popular_movies.PopularMoviesFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Component(modules = [AppModule::class, NetworkModule::class, ViewModelModule::class, DataBaseModule::class])
@Singleton
interface AppComponent {
    fun inject(frag: PopularMoviesFragment)

    @Component.Builder
     interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun application(application: Application): Builder
    }
}

