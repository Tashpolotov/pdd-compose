package com.example.pdd_compose.presentation.profile.component

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.pdd_compose.R

@Composable
fun CustomSeekBar(
    modifier: Modifier = Modifier,
    progress: Float,
    onProgressChange: (Float) -> Unit,
    enabled: Boolean
) {
    Slider(
        value = progress,
        onValueChange = { newValue -> if (enabled) onProgressChange(newValue) },
        valueRange = 0f..100f,
        modifier = modifier
            .height(10.dp), // Устанавливаем высоту
        enabled = enabled,
        colors = SliderDefaults.colors(
            thumbColor = colorResource(id = R.color.color_FF9600),
            activeTrackColor = colorResource(id = R.color.color_FF9600),
            inactiveTrackColor = colorResource(id = R.color.color_777777)
        )
    )
}