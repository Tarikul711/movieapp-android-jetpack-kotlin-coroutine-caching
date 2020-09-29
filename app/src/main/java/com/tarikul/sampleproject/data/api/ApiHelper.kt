package com.tos.myapplication.data.api

import com.tarikul.sampleproject.data.model.movies.MovieResponse
import kotlinx.coroutines.flow.Flow

interface ApiHelper {

    suspend fun getPhotoAlbum(): Flow<MovieResponse>

}