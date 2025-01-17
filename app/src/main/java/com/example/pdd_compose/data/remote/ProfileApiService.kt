package com.example.pdd_compose.data.remote

import com.example.pdd_compose.data.model.profile.ProfileDataModel
import retrofit2.http.GET
import retrofit2.http.Header

interface ProfileApiService {

    @GET("/api/v1/profile/")
    suspend fun getProfile(
        @Header("Authorization") token: String,
        @Header("Accept-Language") language:String): ProfileDataModel
}