package com.example.pdd_compose.domain.repository.auth

import com.example.pdd_compose.domain.model.register.AccessModel
import com.example.pdd_compose.domain.model.register.UserModel
import com.example.pdd_compose.util.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    suspend fun sendNameRegister(name: UserModel):Flow<Resource<AccessModel>>
}