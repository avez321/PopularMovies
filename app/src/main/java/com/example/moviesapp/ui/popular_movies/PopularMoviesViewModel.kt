package com.example.moviesapp.ui.popular_movies

import android.app.Application
import android.view.View
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import com.example.moviesapp.R
import com.example.moviesapp.database.MoviesRepository
import com.example.moviesapp.model.MoviesResponse
import com.example.moviesapp.repository.RepositoryImp
import kotlinx.coroutines.*

import com.example.moviesapp.model.Movie
import com.example.moviesapp.network.ResultWrapper
import com.example.moviesapp.util.isNetworkAvailable
import javax.inject.Inject

class PopularMoviesViewModel @Inject constructor(application: Application) :
    AndroidViewModel(application) {
    @Inject
    lateinit var repositoryImp: RepositoryImp

    @Inject
    lateinit var moviesRepository: MoviesRepository
    private val movieDataObservableField: ObservableField<ArrayList<Movie>?> =
        ObservableField()
    private val progressVisibilityObservableField: ObservableField<Int> = ObservableField()
    private var page: Int = 1


    fun getMoviesData() {
        progressVisibilityObservableField.set(View.VISIBLE)
        if (getApplication<Application?>().applicationContext.isNetworkAvailable()) {
            GlobalScope.launch {
                val resultWarraper = repositoryImp.getMovies(page++)
                withContext(Dispatchers.Main) {
                    when (resultWarraper) {
                        is ResultWrapper.NetworkError -> showNetworkError()
                        is ResultWrapper.GenericError -> showGenericError(resultWarraper)
                        is ResultWrapper.Success -> {
                            if (resultWarraper.value.movies?.size != 0) {
                                showSuccess(resultWarraper.value)
                                GlobalScope.launch(Dispatchers.IO) {
                                    moviesRepository.insertAllMovies(resultWarraper.value.movies as List<Movie>)
                                }
                            } else {
                                Toast.makeText(
                                    getApplication(),
                                    R.string.no_more_data_to_load,
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            }
                        }
                    }
                }
            }
        } else {
            if (page > 1) {
                progressVisibilityObservableField.set(View.GONE)
                Toast.makeText(
                    getApplication(),
                    R.string.no_more_data_to_load,
                    Toast.LENGTH_SHORT
                )
                    .show()

            } else {
                page++
                GlobalScope.launch(Dispatchers.IO) {
                    val movies = moviesRepository.getMoviesData()
                    GlobalScope.launch(Dispatchers.Main) {
                        progressVisibilityObservableField.set(View.GONE)
                        movieDataObservableField.set(movies as ArrayList<Movie>)
                    }
                }
            }
        }
    }

    fun getHomeDataObservableField() = movieDataObservableField

    fun getProgressVisibilityObservableField() = progressVisibilityObservableField


    private fun showSuccess(moviesResponse: MoviesResponse) {
        progressVisibilityObservableField.set(View.GONE)
        movieDataObservableField.set(moviesResponse.movies)
    }

    private fun showGenericError(redditResponse: Any) {
        Toast.makeText(getApplication(), redditResponse.toString(), Toast.LENGTH_SHORT).show()
    }

    private fun showNetworkError() {
        Toast.makeText(getApplication(), "network error", Toast.LENGTH_SHORT).show()
    }
}

