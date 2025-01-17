package com.example.pdd_compose.presentation.rank.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pdd_compose.R

@Composable
fun RankPedestal(
    modifier: Modifier = Modifier,
    textBall: String,
    textRating: String,
    textLessonCompleted: String

) {
    Column(modifier = modifier.wrapContentHeight()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally, // Выравниваем по центру
                modifier = Modifier.align(Alignment.Bottom) // Выравниваем по нижнему краю
            ) {

                Image(
                    modifier = Modifier.padding(top = 16.dp),
                    painter = painterResource(id = R.drawable.ic_star_pedestal),
                    contentDescription = null
                )
                Text(
                    modifier = Modifier.padding(top = 2.dp),
                    text = textBall,
                    lineHeight = 20.sp,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = colorResource(id = R.color.color_FF9600),
                        textAlign = TextAlign.Center
                    )
                )

                Text(
                    modifier = Modifier.padding(top = 2.dp),
                    text = "Всего\nбаллов",
                    lineHeight = 20.sp,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = colorResource(id = R.color.black),
                        textAlign = TextAlign.Center
                    )
                )
                Image(
                    modifier = Modifier.padding(top = 4.dp),
                    painter = painterResource(id = R.drawable.ic_pedestal_coins),
                    contentDescription = null
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally, // Выравниваем по центру
                modifier = Modifier.align(Alignment.Bottom)
            ) {

                Text(
                    modifier = Modifier.padding(top = 16.dp),
                    text = textRating,
                    lineHeight = 20.sp,
                    style = TextStyle(
                        fontSize = 32.sp,
                        color = colorResource(id = R.color.color_FF9600),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                )

                Text(
                    modifier = Modifier.padding(top = 2.dp),
                    text = "Место\nв рейтинге",
                    lineHeight = 20.sp,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = colorResource(id = R.color.black),
                        textAlign = TextAlign.Center
                    )
                )
                Image(
                    modifier = Modifier.padding(top = 4.dp),
                    painter = painterResource(id = R.drawable.ic_pedestal_position),
                    contentDescription = null
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally, // Выравниваем по центру
                modifier = Modifier.align(Alignment.Bottom)
            ) {

                Image(
                    modifier = Modifier.padding(top = 16.dp),
                    painter = painterResource(id = R.drawable.ic_lessons_completed),
                    contentDescription = null
                )
                Text(
                    modifier = Modifier.padding(top = 2.dp),
                    text = textLessonCompleted,
                    lineHeight = 20.sp,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = colorResource(id = R.color.color_FF9600),
                        textAlign = TextAlign.Center
                    )
                )

                Text(
                    modifier = Modifier.padding(top = 2.dp),
                    text = "Пройдено\nуроков",
                    lineHeight = 20.sp,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = colorResource(id = R.color.black),
                        textAlign = TextAlign.Center
                    )
                )
                Image(
                    modifier = Modifier.padding(top = 4.dp),
                    painter = painterResource(id = R.drawable.ic_pedestal_coins),
                    contentDescription = null
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            DividerLine()
        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.align(Alignment.Center)
            ) {
                Text(
                    text = "Рейтинг",
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = colorResource(id = R.color.black),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "Лучшие по баллам",
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.color_777777),
                        textAlign = TextAlign.Center,
                    )
                )
            }
        }

    }

}

@Composable
fun DividerLine() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(2.dp)
            .background(colorResource(id = R.color.purple_700))
    )
}

@Preview(showBackground = true)
@Composable
fun RankPedestalPreview() {
    RankPedestal(
        textBall = "123",
        textRating = "123",
        textLessonCompleted = "123"
    )
}




