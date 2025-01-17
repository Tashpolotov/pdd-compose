package com.example.pdd_compose.presentation.main

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pdd_compose.R
import com.example.pdd_compose.presentation.main.component.HomeViewPager
import com.example.pdd_compose.util.Resource
import dagger.hilt.android.AndroidEntryPoint
import kg.geekstudio.main_domain.model.level.LevelModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: LevelViewModel = hiltViewModel()
) {

    LaunchedEffect(Unit) {
        Log.d("HomeScreen", "Calling loadProfile()")
        viewModel.getLoadMainLevel()
    }

    val levelState by viewModel.mainLevel.collectAsState()

    when (levelState) {
        is Resource.Loading -> {
            // Покажи индикатор загрузки
            Log.d("HomeScreen", "Loading data...")
            // Здесь можно показать что-то вроде CircularProgressIndicator
        }
        is Resource.Success -> {
            val profileData = (levelState as Resource.Success).data ?: emptyList()
            Log.d("HomeScreen", "Loaded data: $profileData") // Логгирование данных

            val firstLevel = profileData.firstOrNull() // Получаем первый элемент, если он существует

            if (firstLevel != null) {
                HomeViewPager(
                    levels = profileData,
                    onProgressChange = { progress -> }
                )
            } else {
                // Обработка случая, когда данные пустые
                Log.d("HomeScreen", "Profile data is empty")
                // Можно показать сообщение об отсутствии данных
            }
        }
        is Resource.Error -> {
            Log.e("HomeScreen", "Error loading data: ${(levelState as Resource.Error).message}")
            // Здесь можно показать сообщение об ошибке
        }

        is Resource.Empty -> {

        }
    }
}