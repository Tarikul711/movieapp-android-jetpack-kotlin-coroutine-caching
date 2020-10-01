package com.tos.androidlivedataviewmodel.projectOne.data.api

import com.tarikul.sampleproject.data.model.movies.MovieResponse
import com.tarikul.sampleproject.data.model.trending.TrendingResponse
import com.tos.myapplication.data.api.ApiHelper
import com.tos.myapplication.data.api.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 *Created by tarikul on 23/9/20
 */

class ApiHelperImpl(var apiService: ApiService, var page: Int) : ApiHelper {
    override suspend fun getMovies(): Flow<MovieResponse> =
        flow { emit(apiService.getMovies(page)) }

    override suspend fun getTrendingMovies(): Flow<TrendingResponse> =
        flow { emit(apiService.getTrendingMovies("day")) }


}