package com.tos.myapplication.data.api

import com.tos.androidlivedataviewmodel.projectOne.data.model.PhotoModel
import kotlinx.coroutines.flow.Flow

interface ApiHelper {

    suspend fun getPhotoAlbum(): Flow<List<PhotoModel>>

}