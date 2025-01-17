package com.example.pdd_compose.presentation.register.onboarding.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pdd_compose.R
import com.example.pdd_compose.presentation.register.onboarding.Page
import com.example.pdd_compose.ui.theme.PddcomposeTheme

@Composable
fun OnBoardingPage(
    modifier: Modifier = Modifier,
    page: Page
) {

    Column(
        modifier = modifier,
    ) {
        Image(
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 60.dp)
                .fillMaxWidth(0.60f)
                .fillMaxHeight(0.40f),
            painter = painterResource(id = page.image),
            contentDescription = null,
            )
        Spacer(modifier = modifier.height(2.dp))
        Text(
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 16.dp),
                color = colorResource(
                    id = R.color.color_0D0D0D),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
            text = page.title)
        Spacer(modifier = modifier.height(16.dp))
        Text(
            modifier = modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = colorResource(
                id = R.color.color_262626),
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            text = page.description)
    }
}

@Preview(showBackground = true )
@Composable
fun OnBoardingScreenPreview(){
    PddcomposeTheme {
        OnBoardingPage(page = Page(
            "Весело учим ПДД!", "Здесь ты сможешь стать настоящим экспертом по ПДД, проходя увлекательные уроки. За каждый пройденный урок ты будешь получать баллы, которые помогут тебе стать настоящим чемпионом дорог!", R.drawable.img_onboarding_third_page
        ))
    }
}