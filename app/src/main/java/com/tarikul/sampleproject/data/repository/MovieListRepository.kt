package com.tarikul.sampleproject.data.repository

import com.tos.myapplication.data.api.ApiHelper

/**
 *Created by tarikul on 16/9/20
 */

class MovieListRepository(private var apiHelper: ApiHelper) {

    suspend fun getMovies() = apiHelper.getMovies()

    suspend fun getTrendingMovies() = apiHelper.getTrendingMovies()

    suspend fun getTvShows() = apiHelper.getTvShows()


}