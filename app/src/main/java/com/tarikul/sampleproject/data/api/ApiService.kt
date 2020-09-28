package com.tos.myapplication.data.api


import retrofit2.http.GET

interface ApiService {
    @GET("photos")
    suspend fun getPhotoAlbum():List<PhotoModel>

}