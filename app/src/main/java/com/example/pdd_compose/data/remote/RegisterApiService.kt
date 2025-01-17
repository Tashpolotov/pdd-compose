package com.example.pdd_compose.data.remote

import com.example.pdd_compose.data.model.register.AccessModelData
import com.example.pdd_compose.domain.model.register.UserModel
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterApiService  {

    @POST("api/v1/registration/")
    suspend fun userRegister(
        @Body username: UserModel
    ): AccessModelData
}