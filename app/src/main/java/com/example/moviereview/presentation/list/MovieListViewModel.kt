package com.example.moviereview.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviereview.api.MoviesRepository
import com.example.moviereview.model.list.MovieList
import kotlinx.coroutines.launch
import retrofit2.Response

class MovieListViewModel : ViewModel(){
    private val movieRepository = MoviesRepository()
    private val moviesListLive = MutableLiveData<Response<MovieList>>()
    val moviesList: LiveData<Response<MovieList>> get() = moviesListLive

    fun getMovies() {
        viewModelScope.launch {
            val response = movieRepository.getMovies()
            moviesListLive.postValue(response)
        }
    }
}