package com.example.pdd_compose.domain.usecase.app_entry

import com.example.pdd_compose.domain.repository.localmanager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManager: LocalUserManager
) {

    operator fun invoke():Flow<Boolean>{
        return localUserManager.readAppEntry()
    }
}