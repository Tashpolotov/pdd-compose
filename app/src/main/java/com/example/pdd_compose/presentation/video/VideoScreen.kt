package com.example.pdd_compose.presentation.video

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.pdd_compose.R

@Composable
fun VideoScreen(modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.onboarding_backround))

    ) {
        Text(
            modifier = modifier
                .padding(top = 100.dp),
            text = "Video Screen")
    }

}