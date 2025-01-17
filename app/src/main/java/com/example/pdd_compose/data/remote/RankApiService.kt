package com.example.pdd_compose.data.remote

import com.example.pdd_compose.data.model.rank.RankModelData
import com.example.pdd_compose.domain.model.rank.RankModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface RankApiService {

    @GET("api/v1/top-ratings/")
    suspend fun getUsers(
        @Header("Authorization") accessToken: String,
        @Header("Accept-Language") language:String
    ): List<RankModelData>

}