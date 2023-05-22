package com.example.moviereview.api

import com.example.moviereview.Links.API_KEY
import com.example.moviereview.model.MovieList
import retrofit2.Response

class MoviesRepository {
    suspend fun getMovies(apikey: String = API_KEY): Response<MovieList>{
        return ApiFactory.moviesApi.getMovieList(apikey)
    }
}