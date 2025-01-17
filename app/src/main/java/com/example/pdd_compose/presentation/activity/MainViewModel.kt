package com.example.pdd_compose.presentation.activity

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pdd_compose.domain.usecase.app_entry.AppEntryUseCase
import com.example.pdd_compose.presentation.nav_graph.Route
import com.example.pdd_compose.util.SharedPref
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCase,
    private val sharedPref: SharedPref
):ViewModel(){

    var splashCondition by mutableStateOf(true)
        private set

    var startDestionation by mutableStateOf(Route.AppStartNavigation.route)
        private set

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    init {
        appEntryUseCases.readAppEntry().onEach { shouldStartFromHomeScreen ->
            Log.d("MainViewModel123", "startDestionation: ${shouldStartFromHomeScreen}")

            // Проверяем, есть ли сохраненный токен
            if (sharedPref.accessToken != null) {
                // Если токен есть, всегда переходим на PddNavigation
                startDestionation = Route.PddNavigation.route
            } else if (shouldStartFromHomeScreen) {
                // Если онбординг еще не пройден
                startDestionation = Route.AuthNavigation.route
            } else {
                // Если онбординг пройден и нет токена
                startDestionation = Route.AppStartNavigation.route
            }

            delay(300)
            splashCondition = false
            Log.d("MainViewModel123", "startDestionation: $startDestionation")

        }.launchIn(viewModelScope)
    }

    fun loadStuff(){
        viewModelScope.launch {
            _isLoading.value = true
            delay(3000L)
            _isLoading.value = false
        }
    }
}
