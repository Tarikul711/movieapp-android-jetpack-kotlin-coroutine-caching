package com.tarikul.sampleproject.data.repository

import com.tos.myapplication.data.api.ApiHelper

/**
 *Created by tarikul on 16/9/20
 */

class MovieDetailRepository(private var apiHelper: ApiHelper) {

    suspend fun getMovieDetails() = apiHelper.getMovieDetails()
    suspend fun getSimilarMovies() = apiHelper.getSimilarMovies()


}