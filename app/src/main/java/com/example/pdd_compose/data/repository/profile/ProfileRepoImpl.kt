package com.example.pdd_compose.data.repository.profile

import com.example.pdd_compose.data.mapper.toProfile
import com.example.pdd_compose.data.remote.ProfileApiService
import com.example.pdd_compose.domain.model.profile.changename.ChangeName
import com.example.pdd_compose.domain.model.profile.delete.DeleteModel
import com.example.pdd_compose.domain.model.profile.profileInfo.ProfileDomainModel
import com.example.pdd_compose.domain.repository.profile.ProfileRepository
import com.example.pdd_compose.util.Resource
import com.example.pdd_compose.util.SharedPref
import com.example.pdd_compose.util.base.BaseRepository
import kotlinx.coroutines.flow.Flow

class ProfileRepoImpl(
    private val apiService: ProfileApiService,
    private val sharedPref: SharedPref
):BaseRepository(), ProfileRepository  {
    override suspend fun getProfile() = doRequest {
        val accessToken = sharedPref.accessToken
        val language = sharedPref.selectedLanguage
        apiService.getProfile("JWT ${accessToken.toString()}", language.toString()).toProfile()
    }

    override suspend fun getChangeName(model: ChangeName): Flow<Resource<String>> {
        TODO("Not yet implemented")
    }

    override suspend fun getDelete(): Flow<Resource<DeleteModel>> {
        TODO("Not yet implemented")
    }
}