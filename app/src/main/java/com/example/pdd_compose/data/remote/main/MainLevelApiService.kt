package com.example.pdd_compose.data.remote.main

import kg.geekstudio.main_data.model.level.LevelDataModel
import retrofit2.http.GET
import retrofit2.http.Header

interface MainLevelApiService {

    @GET("/api/v1/level/")
    suspend fun getMainLevel(
        @Header("Authorization")token: String,
        @Header("Accept-Language") language:String
    ):List<LevelDataModel>
}

