package com.tos.androidlivedataviewmodel.projectOne.data.api

import com.tarikul.sampleproject.data.model.movie.MovieResponse
import com.tarikul.sampleproject.data.model.movieList.MovieListResponse
import com.tarikul.sampleproject.data.model.trendingList.TrendingListResponse
import com.tarikul.sampleproject.data.model.tvShowList.TvShowListResponse
import com.tos.myapplication.data.api.ApiHelper
import com.tos.myapplication.data.api.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 *Created by tarikul on 23/9/20
 */

class ApiHelperImpl(
    var apiService: ApiService, var page: Int = 1,
    var movie_id: String = "497582"
) : ApiHelper {
    override suspend fun getMovies(): Flow<MovieListResponse> =
        flow { emit(apiService.getMovies(page)) }

    override suspend fun getTrendingMovies(): Flow<TrendingListResponse> =
        flow { emit(apiService.getTrendingMovies("day")) }

    override suspend fun getTvShows(): Flow<TvShowListResponse> =
        flow { emit(apiService.getTvShow(page)) }

    override suspend fun getMovieDetails(): Flow<MovieResponse> =
        flow { emit(apiService.getMovieDetails(movie_id)) }

    override suspend fun getSimilarMovies(): Flow<MovieListResponse> =
        flow { emit(apiService.getSimilarMovies(movie_id = movie_id, page = page)) }


}