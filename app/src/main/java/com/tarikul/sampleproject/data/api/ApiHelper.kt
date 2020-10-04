package com.tos.myapplication.data.api

import com.tarikul.sampleproject.data.model.movieList.MovieResponse
import com.tarikul.sampleproject.data.model.trendingList.TrendingResponse
import com.tarikul.sampleproject.data.model.tvShowList.TvShowResponse
import kotlinx.coroutines.flow.Flow

interface ApiHelper {

    suspend fun getMovies(): Flow<MovieResponse>
    suspend fun getTrendingMovies(): Flow<TrendingResponse>
    suspend fun getTvShows(): Flow<TvShowResponse>

}