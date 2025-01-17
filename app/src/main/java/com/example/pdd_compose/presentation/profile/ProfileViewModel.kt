package com.example.pdd_compose.presentation.profile

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.pdd_compose.domain.model.profile.profileInfo.ProfileDomainModel
import com.example.pdd_compose.domain.usecase.profileusecase.ProfileUseCase
import com.example.pdd_compose.util.Resource
import com.example.pdd_compose.util.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val useCase: ProfileUseCase): BaseViewModel() {

    private val _profile = MutableStateFlow<Resource<ProfileDomainModel>>(Resource.Empty())
    val profile = _profile.asStateFlow()

/*
    private val _changeName = MutableStateFlow<Resource<ChangeName>>(Resource.Empty())
    val changeName = _changeName.asStateFlow()

    private val _deleteAccount = MutableStateFlow<Resource<DeleteModel>>(Resource.Empty())
    val deleteAccount = _deleteAccount.asStateFlow()
*/


    fun loadProfile(){
        viewModelScope.launch {
            useCase.getProfile().collectData(_profile)
        }
    }

    /*fun loadChangeName(model: ChangeName) {
        viewModelScope.launch {
            useCase.getChangeName(model).collect { resource ->
                when (resource) {
                    is Resource.Success -> {

                        Log.d("ChangeName", "Success: ${resource.data}")
                    }
                    is Resource.Error -> {

                        Log.e("ChangeName", "Error: ${resource.message}")
                    }
                    is Resource.Loading -> {

                    }

                    else -> {}
                }
            }
        }
    }

    fun deleteAccount(){
        viewModelScope.launch {
            useCase.getDelete().collectData(_deleteAccount)
        }
    }*/
}