package com.example.moviesapp.database

import com.example.moviesapp.model.Movie

class MoviesRepository(private val moviesDao: MoviesDao) {

    suspend fun getMoviesData() = moviesDao.getMoviesData()

     suspend fun insertMovies(movie: Movie) {
        moviesDao.insert(movie)
    }

    suspend fun  insertAllMovies(arraylist: List<Movie>) {
        moviesDao.insertAll(arraylist)
    }
}