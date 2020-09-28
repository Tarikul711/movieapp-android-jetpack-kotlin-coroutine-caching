package com.tos.myapplication.data.api


import com.tarikul.sampleproject.data.api.Endpoint.DISCOVER_MOVIE
import com.tarikul.sampleproject.data.api.Endpoint.DISCOVER_TV
import com.tarikul.sampleproject.data.model.movies.MovieResponse
import retrofit2.http.GET

interface ApiService {

    @GET(DISCOVER_MOVIE)
    suspend fun getMovies(): MovieResponse

    @GET(DISCOVER_TV)
    suspend fun getTvShows(): MovieResponse

}