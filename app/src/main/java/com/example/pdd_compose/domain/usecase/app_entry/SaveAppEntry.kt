package com.example.pdd_compose.domain.usecase.app_entry

import com.example.pdd_compose.domain.repository.localmanager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {

    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}