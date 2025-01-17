package com.example.pdd_compose.domain.usecase

import com.example.pdd_compose.domain.usecase.level.MainLevelUseCase
import com.example.pdd_compose.domain.usecase.profileusecase.ProfileUseCase
import com.example.pdd_compose.domain.usecase.rank.GetAllUsersUseCase
import com.example.pdd_compose.domain.usecase.registerusecase.RegisterUseCase

data class UsaCases(
    val registerUseCase: RegisterUseCase,
    val profileUseCase: ProfileUseCase,
    val rankUseCase: GetAllUsersUseCase,
    val levelUseCase: MainLevelUseCase
)