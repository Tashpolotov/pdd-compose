package com.example.pdd_compose.data.repository.rank

import com.example.pdd_compose.data.mapper.toRank
import com.example.pdd_compose.data.remote.RankApiService
import com.example.pdd_compose.domain.repository.rank.RankRepository
import com.example.pdd_compose.util.SharedPref
import com.example.pdd_compose.util.base.BaseRepository

class RankRepositoryImpl(
    private val apiService: RankApiService,
    private val sharedPref: SharedPref
) :RankRepository, BaseRepository(){
    override suspend fun getUsers() = listRequest {
        val accessToken = sharedPref.accessToken
        val language = sharedPref.selectedLanguage
        val respones = apiService.getUsers("JWT ${accessToken.toString()}", language.toString())
        respones.map { it.toRank() }
    }

}