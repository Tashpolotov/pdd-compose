package com.example.pdd_compose.presentation.profile.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pdd_compose.R


@Composable
fun StatisticRankCard(
    rank: String,
    score: Int,
    nextRank: String,
    progress: Float,
    onProgressChange: (Float) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 12.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()

        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 14.dp, end = 12.dp, top = 12.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_shield),
                    contentDescription = null,
                )
                Column(
                    modifier = Modifier.padding(start = 8.dp),
                ) {
                    Text(
                        text = rank,
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = colorResource(id = R.color.color_FF9600)
                        ),
                    )
                    Text(
                        text = "Ранг",
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = colorResource(id = R.color.color_777777)
                        ),
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }

            }

            CustomSeekBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 14.dp, top = 10.dp, end = 12.dp),
                progress = progress,
                onProgressChange = onProgressChange,
                enabled = false
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(

                    text = score.toString(),
                    modifier = Modifier.padding(start = 14.dp, end = 12.dp, top = 10.dp, bottom = 12.dp),
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = colorResource(id = R.color.color_777777)
                    )
                )

                Text(
                    text = nextRank,
                    modifier = Modifier.padding(start = 14.dp, end = 12.dp, top = 4.dp, bottom = 12.dp),
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = colorResource(id = R.color.color_777777)
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardPreview(){
    var progress by remember { mutableStateOf(50f) }
    StatisticRankCard(
        rank = "asd",
        score = "20/465465".toInt(),
        nextRank = "Командир по скамейкамвыф ",
        progress = progress,
        onProgressChange = { newProgress -> progress = newProgress }
    )
}

