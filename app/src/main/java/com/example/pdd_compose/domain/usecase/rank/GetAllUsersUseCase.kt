package com.example.pdd_compose.domain.usecase.rank

import com.example.pdd_compose.domain.repository.rank.RankRepository
import javax.inject.Inject

class GetAllUsersUseCase @Inject constructor(private val rankRepository: RankRepository) {

    suspend fun getUsers() = rankRepository.getUsers()

}