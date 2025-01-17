package com.example.pdd_compose.domain.repository.profile

import com.example.pdd_compose.domain.model.profile.changename.ChangeName
import com.example.pdd_compose.domain.model.profile.delete.DeleteModel
import com.example.pdd_compose.domain.model.profile.profileInfo.ProfileDomainModel
import com.example.pdd_compose.util.Resource
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {

    suspend fun getProfile(): Flow<Resource<ProfileDomainModel>>

    suspend fun getChangeName(model: ChangeName):Flow<Resource<String>>

    suspend fun getDelete():Flow<Resource<DeleteModel>>

}