package com.example.pdd_compose.presentation.register

import androidx.lifecycle.viewModelScope
import com.example.pdd_compose.domain.model.register.AccessModel
import com.example.pdd_compose.domain.model.register.UserModel
import com.example.pdd_compose.domain.usecase.registerusecase.RegisterUseCase
import com.example.pdd_compose.util.Resource
import com.example.pdd_compose.util.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val useCase: RegisterUseCase
):BaseViewModel(){

    private val _user = MutableStateFlow<Resource<AccessModel>>(Resource.Empty())
    val user = _user.asStateFlow()

    fun sendName(name: UserModel){
        viewModelScope.launch {

            useCase.sendName(name).collectData(_user)
        }
    }

}