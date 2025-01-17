package com.example.pdd_compose.presentation.profile.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pdd_compose.R

@Composable
fun StatisticUserCard(
    img: Int,
    point: String,
    titlePoint: String
) {
    Card(
        modifier = Modifier
            .padding(start = 12.dp, end = 12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = img),
                    contentDescription = null,
                )
                Column(
                    modifier = Modifier.padding(start = 8.dp)

                ) {
                    Text(
                        text = point,
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = colorResource(id = R.color.color_FF9600)
                        )
                    )
                    Text(
                        text = titlePoint,
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = colorResource(id = R.color.color_777777)
                        )
                    )
                }
            }
        }
    }


}