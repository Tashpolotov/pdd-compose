package com.example.pdd_compose.presentation.main

import androidx.lifecycle.viewModelScope
import com.example.pdd_compose.domain.usecase.level.MainLevelUseCase
import com.example.pdd_compose.util.Resource
import com.example.pdd_compose.util.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kg.geekstudio.main_domain.model.level.LevelModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LevelViewModel @Inject constructor(
    private val useCase: MainLevelUseCase
):BaseViewModel() {

    private val _mainLevel = MutableStateFlow<Resource<List<LevelModel>>>(Resource.Empty())
    val mainLevel = _mainLevel.asStateFlow()

    fun getLoadMainLevel() {
        viewModelScope.launch {
            useCase.getMailLevel().collectData(_mainLevel)
        }
    }

}