package com.example.pdd_compose.domain.usecase.profileusecase

import com.example.pdd_compose.domain.repository.profile.ProfileRepository
import javax.inject.Inject

class ProfileUseCase @Inject constructor(
    private val repository: ProfileRepository
) {
    suspend fun getProfile() = repository.getProfile()

}