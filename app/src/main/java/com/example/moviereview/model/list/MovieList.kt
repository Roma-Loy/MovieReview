package com.example.moviereview.model.list

import com.example.moviereview.model.list.Movie

data class MovieList(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)