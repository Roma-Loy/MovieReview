package com.example.moviereview.api

import com.example.moviereview.model.MovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesIntarface {
    @GET("movie/popular")
    suspend fun getMovieList(
        @Query("api_key") apikey: String,
        @Query("language") language: String = "uk"
    ) : Response<MovieList>
}