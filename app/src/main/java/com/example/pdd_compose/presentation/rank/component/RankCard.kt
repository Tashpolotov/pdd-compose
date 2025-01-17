package com.example.pdd_compose.presentation.rank.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.pdd_compose.R

@Composable
fun RankCard(
    modifier: Modifier = Modifier,
    userName: String,
    userRole: String,
    lessonsCompleted: String,
    borderColor: Color = Color.Transparent, // Добавляем цвет бордюра как параметр
    borderWidth: Dp = 0.dp,
    index : Int,
    textYou:String,
) {
    val context = LocalContext.current

    Card(modifier = modifier
        .padding(horizontal = 16.dp, vertical = 8.dp)
        .fillMaxWidth()
        .border( // Применяем бордюр к карточке
            width = borderWidth,
            color = borderColor,
            shape = RoundedCornerShape(12.dp)
        )
        .clickable {}
    ) {
        Row(modifier = Modifier
            .padding(horizontal = 12.dp)
            .clickable { TODO("передать клик") }) {
            if(index <= 2){
                Image(
                    modifier = Modifier.align(alignment = Alignment.CenterVertically),
                    painter = painterResource(
                        id = when (index) {
                            0 -> R.drawable.ic_first_place // Кубок для 1-го места
                            1 -> R.drawable.ic_second_place // Кубок для 2-го места
                            2 -> R.drawable.ic_third_place  // Кубок для 3-го места
                            else -> R.drawable.ic_first_place
                        }
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            } else {
                Text(
                    text = textYou,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = colorResource(id = R.color.black)
                    ),
                    modifier = Modifier.align(alignment = Alignment.CenterVertically)
                )
            }


            AsyncImage(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .padding(vertical = 22.dp)
                    .size(36.dp)
                    .clip(MaterialTheme.shapes.medium),
                model = ImageRequest.Builder(context).data(R.drawable.ic_enot_tarelka).build()
                , contentDescription = null,
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier.padding(vertical = 10.dp),

            ) {
                Text(
                    modifier = Modifier
                        .padding(start = 6.dp),
                    text = userName,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = colorResource(id = R.color.black)
                    )
                
                )
                Text(
                    modifier = Modifier.padding(start = 6.dp, top = 6.dp),
                    text = userRole,
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = colorResource(id = R.color.color_4097A7)
                    )

                )
                Text(
                    modifier = Modifier.padding(start = 6.dp, top = 6.dp),
                    text = lessonsCompleted,
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = colorResource(id = R.color.color_8A8A8A)
                    )
                
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Column(
                modifier = Modifier.padding(vertical = 19.dp),
                horizontalAlignment = Alignment.End,

                ) {
                Image(
                    modifier = Modifier
                        .padding(start = 6.dp, end = 12.dp)
                    ,
                    painter = painterResource(id = R.drawable.ic_star_pedestal),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(colorResource(id = R.color.color_1CA1BF))
                )

                Text(
                    modifier = Modifier.padding(start = 6.dp, top = 4.dp, end = 12.dp),
                    textAlign = TextAlign.End,
                    text = "Пройдено уроков:22",
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = colorResource(id = R.color.color_FF9600)
                    )

                )

            }
        }

    }
}