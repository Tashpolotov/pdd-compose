package com.example.pdd_compose.domain.usecase.registerusecase

import com.example.pdd_compose.domain.model.register.UserModel
import com.example.pdd_compose.domain.repository.auth.AuthRepository
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend fun sendName(name: UserModel) = repository.sendNameRegister(name)

}