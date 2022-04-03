package com.example.moviesapp

import androidx.multidex.MultiDexApplication
import com.example.moviesapp.di.component.DaggerAppComponent


class MoviesApp : MultiDexApplication() {

    lateinit var appComponent: DaggerAppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().application(this).build() as DaggerAppComponent

    }

}