package com.example.pdd_compose.data.repository

import android.util.Log
import com.example.pdd_compose.data.mapper.toLevel
import com.example.pdd_compose.data.remote.main.MainLevelApiService
import com.example.pdd_compose.domain.repository.main.level.MainLevelRepository
import com.example.pdd_compose.util.SharedPref
import com.example.pdd_compose.util.base.BaseRepository
import javax.inject.Inject

class MainLevelRepositoryImpl @Inject constructor(
    private val apiService: MainLevelApiService,
    private val sharedPref: SharedPref
) :
    BaseRepository(), MainLevelRepository {

    override suspend fun getMailLevel() = listRequest {
        val accessToken = sharedPref.accessToken.toString()
        val language = sharedPref.selectedLanguage.toString()
      //  Log.d("repo", "Access Token: $accessToken, Language: $language")
        val levelDataModels = apiService.getMainLevel("JWT ${accessToken.toString()}", language)
        Log.d("repo", "fetched: $levelDataModels")
        levelDataModels.map { it.toLevel() }
    }
}