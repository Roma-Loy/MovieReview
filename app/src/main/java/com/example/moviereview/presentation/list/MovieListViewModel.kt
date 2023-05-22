package com.example.moviereview.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.DiffUtil
import com.example.moviereview.api.MoviesRepository
import com.example.moviereview.model.Movie
import com.example.moviereview.model.MovieList
import kotlinx.coroutines.launch
import retrofit2.Response

class MovieListViewModel : ViewModel(){
    private val repository = MoviesRepository()
    private val _myMovies = MutableLiveData<Response<MovieList>>()
    val myMovies: LiveData<Response<MovieList>> get() = _myMovies

    fun getMovies() {
        viewModelScope.launch {
            _myMovies.value = repository.getMovies()
        }
    }
}