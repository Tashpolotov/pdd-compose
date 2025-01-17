package com.example.pdd_compose.data.repository

import com.example.pdd_compose.data.repository.profile.ProfileRepoImpl
import com.example.pdd_compose.data.repository.register.RegisterRepoImpl
import com.example.pdd_compose.domain.repository.auth.AuthRepository
import com.example.pdd_compose.domain.repository.profile.ProfileRepository

data class RepositoryImpl(
    val profileRepoImpl: ProfileRepository,
    val registerRepoImpl: AuthRepository
)