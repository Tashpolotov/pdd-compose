package com.example.pdd_compose.presentation.rank

import androidx.lifecycle.viewModelScope
import com.example.pdd_compose.domain.model.rank.RankModel
import com.example.pdd_compose.domain.usecase.rank.GetAllUsersUseCase
import com.example.pdd_compose.util.Resource
import com.example.pdd_compose.util.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RankViewModel @Inject constructor(
    private val useCase: GetAllUsersUseCase
):BaseViewModel() {

    private val _rank = MutableStateFlow<Resource<List<RankModel>>>(Resource.Empty())
    val rank = _rank.asStateFlow()

    fun loadRank() {
        viewModelScope.launch {
            useCase.getUsers().collectData(_rank)
        }
    }
}