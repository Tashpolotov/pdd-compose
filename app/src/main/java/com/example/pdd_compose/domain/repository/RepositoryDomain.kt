package com.example.pdd_compose.domain.repository

import com.example.pdd_compose.domain.repository.auth.AuthRepository
import com.example.pdd_compose.domain.repository.main.level.MainLevelRepository
import com.example.pdd_compose.domain.repository.profile.ProfileRepository
import com.example.pdd_compose.domain.repository.rank.RankRepository

data class RepositoryDomain(
    val authRepository: AuthRepository,
    val profileRepository: ProfileRepository,
    val rankRepository: RankRepository,
    val levelRepository: MainLevelRepository
)