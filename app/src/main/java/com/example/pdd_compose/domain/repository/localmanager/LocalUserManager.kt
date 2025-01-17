package com.example.pdd_compose.domain.repository.localmanager

import kotlinx.coroutines.flow.Flow

interface LocalUserManager {

    suspend fun saveAppEntry()

    fun readAppEntry():Flow<Boolean>


}