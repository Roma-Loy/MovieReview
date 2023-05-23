package com.example.moviereview.api

import com.example.moviereview.model.list.MovieList
import com.example.moviereview.model.details.MovieDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesIntarface {
    @GET("movie/popular")
    suspend fun getMovieList(
        @Query("api_key") apikey: String,
        @Query("language") language: String = "uk"
    ) : Response<MovieList>


    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") id: Int,
        @Query("api_key") apikey: String,
        @Query("language") language: String = "uk"
    ) : Response<MovieDetails>
}