package com.example.pdd_compose.domain.repository.main.level


import com.example.pdd_compose.util.Resource
import kg.geekstudio.main_domain.model.level.LevelModel
import kotlinx.coroutines.flow.Flow

interface MainLevelRepository {

    suspend fun getMailLevel():Flow<Resource<List<LevelModel>>>

}