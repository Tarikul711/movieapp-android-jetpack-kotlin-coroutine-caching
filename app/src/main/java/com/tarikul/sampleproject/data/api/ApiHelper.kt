package com.tos.myapplication.data.api

import com.tarikul.sampleproject.data.model.movie.MovieResponse
import com.tarikul.sampleproject.data.model.movieList.MovieListResponse
import com.tarikul.sampleproject.data.model.trendingList.TrendingListResponse
import com.tarikul.sampleproject.data.model.tvShowList.TvShowListResponse
import kotlinx.coroutines.flow.Flow

interface ApiHelper {

    suspend fun getMovies(): Flow<MovieListResponse>
    suspend fun getTrendingMovies(): Flow<TrendingListResponse>
    suspend fun getTvShows(): Flow<TvShowListResponse>
    suspend fun getMovieDetails(): Flow<MovieResponse>

}