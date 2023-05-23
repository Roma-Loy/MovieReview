package com.example.moviereview.api

import com.example.moviereview.Links.API_KEY
import com.example.moviereview.model.list.MovieList
import com.example.moviereview.model.details.MovieDetails
import retrofit2.Response

class MoviesRepository {
    suspend fun getMovies(apikey: String = API_KEY): Response<MovieList>{
        return ApiFactory.moviesApi.getMovieList(apikey)
    }
    suspend fun getInfo(id: Int, apikey: String = API_KEY):Response<MovieDetails>{
        return ApiFactory.moviesApi.getMovieDetails(id, apikey)
    }
}