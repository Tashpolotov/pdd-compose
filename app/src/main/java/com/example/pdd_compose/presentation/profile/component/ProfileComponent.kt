package com.example.pdd_compose.presentation.profile.component

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.pdd_compose.R

@Composable
fun ProfileComponent(
    onSettingsClick: @Composable () -> Unit,
    onEditClick: () -> Unit,
    onClickDelete:() -> Unit,
    name:String,
    img:String,
    rank: String,
    score: Int,
    nextRank: String,
    progress: Float,
    point: String,
    point1: String,
    point2: String,

    ) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                WindowInsets.systemBars.asPaddingValues()
            )
            .background(color = colorResource(id = R.color.onboarding_backround)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = rememberImagePainter(data = img),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 24.dp)
                            .width(180.dp)
                            .height(180.dp)
                    )
                    IconButton(
                        onClick = { /* Действие при нажатии */ },
                        modifier = Modifier
                            .padding(top = 12.dp)
                            .align(Alignment.TopEnd),


                        ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_setting),
                            contentDescription = null,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier
                        .padding(start = 16.dp, top = 12.dp),
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.Bold
                    ),
                    text = name
                )
                IconButton(
                    onClick = { /*TODO*/ }) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_pencil),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }
            }
            Spacer(modifier = Modifier.height(12.dp))

            Column(
                modifier = Modifier
            ) {
                StatisticRankCard(
                    rank = rank,
                    score = score,
                    nextRank = nextRank,
                    progress = progress

                ) {

                }
                Spacer(modifier = Modifier.height(8.dp))

                StatisticUserCard(
                    img = R.drawable.ic_star,
                    point = point,
                    titlePoint = "Всего баллов"
                )
                Spacer(modifier = Modifier.height(8.dp))

                StatisticUserCard(
                    img = R.drawable.ic_ok_check,
                    point = point1,
                    titlePoint = "Пройдено уроков"
                )
                Spacer(modifier = Modifier.height(8.dp))
                StatisticUserCard(
                    img = R.drawable.ic_list_check,
                    point = point2,
                    titlePoint = "Пройдено тестов"
                )

            }
            Spacer(modifier = Modifier.height(20.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                TextButton(onClick = { /*TODO*/ }) {
                    Text(
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = colorResource(id = R.color.color_F61111)
                        ),
                        text = "Удалить аккаунт"
                    )
                }
            }
        }
    }
}
