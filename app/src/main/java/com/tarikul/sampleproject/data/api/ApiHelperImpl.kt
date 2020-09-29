package com.tos.androidlivedataviewmodel.projectOne.data.api

import com.tos.androidlivedataviewmodel.projectOne.data.model.PhotoModel
import com.tos.myapplication.data.api.ApiHelper
import com.tos.myapplication.data.api.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 *Created by tarikul on 23/9/20
 */

class ApiHelperImpl(var apiService: ApiService) : ApiHelper {
    override suspend fun getPhotoAlbum(): Flow<List<PhotoModel>> =
        flow { emit(apiService.getPhotoAlbum()) }

}