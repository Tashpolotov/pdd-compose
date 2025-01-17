package com.example.pdd_compose.presentation.register.onboarding

import androidx.annotation.DrawableRes
import com.example.pdd_compose.R

data class Page(
    val title:String,
    val description:String,
    @DrawableRes val image:Int,
)

val pages = listOf(
    Page("Весело учим ПДД!",
        "Здесь ты сможешь стать настоящим экспертом по ПДД," +
                " проходя увлекательные уроки. За каждый пройденный урок ты будешь получать баллы," +
                " которые помогут тебе стать настоящим чемпионом дорог!", R.drawable.img_onboarding_first_page),

    Page("Смотри и учись!",
        "У нас есть крутые обучающие видео, которые сделают из тебя настоящего профессионала в ПДД." +
                " Погружайся в мир дорожной безопасности вместе с яркими персонажами!",
        R.drawable.img_onboarding_second_page),

    Page("Стань чемпионом ПДД!",
        "Проходи уроки, зарабатывай баллы и вступай в захватывающие соревнования. Стань лучшим и получи заслуженные награды. Дорога ждет своего нового чемпиона – может, это будешь именно ты?",
        R.drawable.img_onboarding_third_page),

    )
