package com.tarikul.sampleproject.data.model.movieList

data class MovieResponse(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)