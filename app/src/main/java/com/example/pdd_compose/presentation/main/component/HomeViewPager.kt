package com.example.pdd_compose.presentation.main.component

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.material3.Text
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.scale
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.offset
import androidx.compose.ui.unit.sp
import com.example.pdd_compose.R
import com.example.pdd_compose.presentation.profile.component.CustomSeekBar
import kotlin.math.roundToInt
import androidx.compose.ui.util.lerp
import kg.geekstudio.main_domain.model.level.LevelModel
import kg.geekstudio.main_domain.model.level.PassedLessonsModel
import kg.geekstudio.main_domain.model.level.PointsModel
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeViewPager(
    modifier: Modifier = Modifier,
    levels: List<LevelModel>,
    onProgressChange: (Float) -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        val pagerState = rememberPagerState(pageCount = { levels.size })
        var size by remember { mutableStateOf(IntSize.Zero) }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 4.dp)
                .onGloballyPositioned { coordinates ->
                    size = coordinates.size
                },

            pageSpacing = -0.2.dp,

            ) { page ->
            val level = levels[page]
            val pageOffset = (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction
            val offsetX = pageOffset * size.width * 0.2f
            Column(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth()
            )
            {

                Box(
                    modifier = Modifier
                        .wrapContentSize()
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .padding(top = 120.dp),
                        style = TextStyle(
                            color = colorResource(R.color.color_0D0D0D),
                            fontSize = 12.sp

                        ),
                        text = level.description
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_enot_tarelka),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))

                Card(
                    modifier = Modifier
                        .offset { IntOffset(offsetX.roundToInt(), 0) }
                        .scale(lerp(0.8f, 1f, 1 - pageOffset.absoluteValue))
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .padding(bottom = 16.dp),
                    shape = RoundedCornerShape(20.dp)

                ) {
                    Column(
                        modifier = Modifier
                            .background(color = colorResource(R.color.color_1CA1BF))
                    ) {

                        Text(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(10.dp),
                            text = "Уровень : ${level.order}",
                            style = TextStyle(
                                color = colorResource(R.color.white),
                                fontSize = 20.sp
                            )
                        )

                        Text(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(top = 10.dp),
                            text = "Тема: ${level.name}",
                            style = TextStyle(
                                color = colorResource(R.color.white),
                                fontSize = 16.sp

                            )
                        )

                        Text(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(top = 17.dp),
                            text = "${level.points?.user_points} - ${level.points?.level_points}" ,
                            style = TextStyle(
                                color = colorResource(R.color.white),
                                fontSize = 14.sp
                                )
                        )
                        CustomSeekBar(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(start = 14.dp, top = 10.dp, end = 12.dp),
                            progress = calculateProgress(level.points),
                            enabled = false
                        )


                        Text(
                            modifier = Modifier
                                .align(Alignment.Start)
                                .padding(top = 10.dp, start = 16.dp),
                            text = "proideno urokov: ${level.passed_lessons?.user_lessons} - ${level.passed_lessons?.level_lessons}",
                            style = TextStyle(
                                color = colorResource(R.color.white),
                                fontSize = 12.sp
                                )
                        )

                        Button(
                            modifier = Modifier
                                .padding(all = 16.dp)
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(R.color.white)
                            ),
                            onClick = {

                            }
                        ) {
                            Text(
                                modifier = Modifier,
                                style = TextStyle(
                                    color = colorResource(R.color.color_FF9600),
                                    fontSize = 16.sp,
                                ),

                                text = "PEREITI K UROKAM"
                            )
                        }
                    }
                }

            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}
private fun calculateProgress(points: PointsModel?): Float {
    if (points == null) return 0f
    return (points.user_points.toFloat() / points.level_points.toFloat()).coerceIn(0f, 1f)
}

