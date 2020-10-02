package com.tos.myapplication.data.api

import com.tarikul.sampleproject.data.model.movies.MovieResponse
import com.tarikul.sampleproject.data.model.trending.TrendingResponse
import com.tarikul.sampleproject.data.model.tvShows.TvShowResponse
import kotlinx.coroutines.flow.Flow

interface ApiHelper {

    suspend fun getMovies(): Flow<MovieResponse>
    suspend fun getTrendingMovies(): Flow<TrendingResponse>
    suspend fun getTvShows(): Flow<TvShowResponse>

}