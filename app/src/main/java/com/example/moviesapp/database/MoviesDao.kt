package com.example.moviesapp.database

import androidx.room.*
import com.example.moviesapp.model.Movie


@Dao
interface MoviesDao {
    @Query("SELECT * FROM movies_table")
    fun getMoviesData(): List<Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movie: Movie)

    @Query("DELETE FROM movies_table")
    fun deleteAll()

    @Update
    fun update(article: Movie)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(article: List<Movie>)
}