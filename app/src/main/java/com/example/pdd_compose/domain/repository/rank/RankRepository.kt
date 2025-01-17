package com.example.pdd_compose.domain.repository.rank

import com.example.pdd_compose.domain.model.rank.RankModel
import com.example.pdd_compose.util.Resource
import kotlinx.coroutines.flow.Flow

interface RankRepository {

    suspend fun getUsers(): Flow<Resource<List<RankModel>>>

}