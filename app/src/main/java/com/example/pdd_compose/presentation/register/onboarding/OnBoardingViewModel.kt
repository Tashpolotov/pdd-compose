package com.example.pdd_compose.presentation.register.onboarding

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pdd_compose.domain.usecase.app_entry.AppEntryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val useCase: AppEntryUseCase
):ViewModel(){

    fun onEvent(event: OnBoardingEvent){
        when(event){
            is OnBoardingEvent.SaveAppEntry->{
                saveAppEntry()
            }
        }
    }

    private  fun saveAppEntry() {
        viewModelScope.launch {
            Log.d("OnBoardingViewModel", "Attempting to save app entry")
            useCase.saveAppEntry()
            Log.d("OnBoardingViewModel", "App entry saved successfully")
        }
    }
}