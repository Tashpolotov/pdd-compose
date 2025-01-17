package com.example.pdd_compose.presentation.profile.component

import android.view.View
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pdd_compose.R

@Composable
fun SettingBottomSheet(
    onDismiss: () -> Unit,
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(Color.Black) // Задайте цвет для вашей вьюшки
                .align(alignment = Alignment.CenterHorizontally)
        )
        Text(modifier = Modifier
            .padding(all = 16.dp),
            text = "Настройки",
            style = TextStyle(
                fontSize = 20.sp,
                color = colorResource(R.color.color_0D0D0D)
            )
        )

    }

}


@Preview(showBackground = true)
@Composable
fun SettingBottomSheetPreview() {
    SettingBottomSheet(onDismiss = {})
}