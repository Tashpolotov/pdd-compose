package com.example.pdd_compose.data.repository.register

import com.example.pdd_compose.data.remote.RegisterApiService
import com.example.pdd_compose.domain.model.register.UserModel
import com.example.pdd_compose.domain.repository.auth.AuthRepository
import com.example.pdd_compose.util.base.BaseRepository
import com.example.pdd_compose.data.mapper.toDomain
import com.example.pdd_compose.util.SharedPref


class RegisterRepoImpl(
    private val apiService: RegisterApiService,
    private val sharedPref: SharedPref
):BaseRepository(), AuthRepository {

    override suspend fun sendNameRegister(name: UserModel) = doRequest {
        val response = apiService.userRegister(name).toDomain()
        sharedPref.accessToken = response.access
        response

    }
}