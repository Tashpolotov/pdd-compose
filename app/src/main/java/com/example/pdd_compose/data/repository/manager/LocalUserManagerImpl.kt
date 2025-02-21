package com.example.pdd_compose.data.repository.manager

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.pdd_compose.domain.repository.localmanager.LocalUserManager
import com.example.pdd_compose.util.Constants
import com.example.pdd_compose.util.Constants.USER_SETTINGS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalUserManagerImpl(private val context: Context) : LocalUserManager {

    override suspend fun saveAppEntry() {
        Log.d("LocalUserManagerImpl", "Saving app entry status as true")
        context.dataStore.edit { settings ->
            settings[PreferencesKeys.APP_ENTRY] = true
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map { settings ->
            val appEntryStatus = settings[PreferencesKeys.APP_ENTRY] ?: false
            Log.d("LocalUserManagerImpl", "Reading app entry status: $appEntryStatus")
            appEntryStatus
        }
    }

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS)

    private object PreferencesKeys {
        val APP_ENTRY = booleanPreferencesKey(name = Constants.APP_ENTRY)
    }
}
