package com.example.pdd_compose.domain.usecase.level

import com.example.pdd_compose.domain.repository.main.level.MainLevelRepository
import javax.inject.Inject


class MainLevelUseCase @Inject constructor(private val repository: MainLevelRepository) {

    suspend fun getMailLevel() = repository.getMailLevel()

}