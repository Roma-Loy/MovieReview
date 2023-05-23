package com.example.moviereview.presentation.info

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviereview.api.MoviesRepository
import com.example.moviereview.model.details.MovieDetails
import kotlinx.coroutines.launch
import retrofit2.Response

class MovieInfoViewModel : ViewModel() {
    private val movieRepository = MoviesRepository()
    private val moviesListLive = MutableLiveData<Response<MovieDetails>>()
    val movieDetails: LiveData<Response<MovieDetails>> get() = moviesListLive

    fun getMovies(id:Int) {
        viewModelScope.launch {
            val response = movieRepository.getInfo(id)
            moviesListLive.postValue(response)
        }
    }
}