package com.example.pdd_compose.presentation.rank

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pdd_compose.R
import com.example.pdd_compose.domain.model.rank.RankModel
import com.example.pdd_compose.presentation.profile.ProfileViewModel
import com.example.pdd_compose.presentation.rank.component.RankCard
import com.example.pdd_compose.presentation.rank.component.RankPedestal
import com.example.pdd_compose.util.Resource

@Composable
fun RankScreen(
    modifier: Modifier = Modifier,
    viewModel: RankViewModel = hiltViewModel(),
) {
    LaunchedEffect(Unit) {
        viewModel.loadRank()
    }

    val viewModelState by viewModel.rank.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.onboarding_backround))
    ) {
        // Вынесите RankPedestal за пределы LazyColumn
        Column(
            modifier = Modifier.padding(top = 30.dp)) {
            when (viewModelState) {
                is Resource.Loading -> {
                }

                is Resource.Success -> {
                    val rankData = (viewModelState as Resource.Success).data ?: emptyList()

                    if (rankData.isNotEmpty()) {
                        val firstRank = rankData[0]
                        RankPedestal(
                            modifier = Modifier
                                .height(IntrinsicSize.Min)
                                .padding(16.dp),
                            textBall = firstRank.total_points.toString(),
                            textRating = firstRank.temp_rank.toString(),
                            textLessonCompleted = firstRank.completed_lesson.toString()
                        )
                    }
                    LazyColumn {
                        itemsIndexed(rankData) { index, rank ->
                            // Логирование для проверки индексов и загружаемых данных
                            Log.d("RankScreen", "Rendering item at index: $index, rank: ${rank.user}")

                            // Определяем цвет бордюра для первых трёх мест
                            val borderColor = when (index) {
                                0 -> Color.Yellow   // Золотой для 1-го места
                                1 -> Color.Gray     // Серебряный для 2-го места
                                2 -> Color.Red      // Красный для 3-го места
                                else -> Color.Transparent // Без бордюра для остальных
                            }

                            // Применяем бордюр к карточкам только для первых трёх
                            RankCard(
                                borderWidth = 1.dp,
                                borderColor = borderColor,
                                userName = if(rank.is_current_user) {
                                    "Ty"
                                } else {
                                    rank.user
                                },
                                userRole = rank.rank,
                                lessonsCompleted = rank.temp_rank.toString(),
                                index = index,
                                textYou = rank.temp_rank.toString()
                            )
                        }
                    }
                }

                is Resource.Error -> {
                    // Выводим сообщение об ошибке
                    Text(text = "Ошибка загрузки: ${(viewModelState as Resource.Error).message}")
                }

                is Resource.Empty -> {

                }
            }
        }
    }
}




