package com.example.pdd_compose.presentation.register.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pdd_compose.presentation.common.OnBoardingButton
import com.example.pdd_compose.presentation.register.onboarding.component.OnBoardingIndicator
import com.example.pdd_compose.presentation.register.onboarding.component.OnBoardingPage
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
     onEvent: (OnBoardingEvent) -> Unit

) {
    val pageState = rememberPagerState(initialPage = 0) {
        pages.size
    }
    val buttonState = remember {
        derivedStateOf {
            when (pageState.currentPage) {
                0 -> listOf("Дальше")
                1 -> listOf("Дальше")
                2 -> listOf("Начать")
                else -> listOf("", "")
            }
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(state = pageState) {
            OnBoardingPage(page = pages[it])
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .navigationBarsPadding(),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Spacer(modifier = Modifier.weight(1f))

            OnBoardingIndicator(
                modifier = Modifier

                    .fillMaxWidth(),
                pageSize = pages.size,
                selectedPage = pageState.currentPage,
            )
            Row(
                modifier = Modifier
                    .padding(top = 24.dp, bottom = 24.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                val scope = rememberCoroutineScope()

                // Hide the button when the first element of the list is empty
                if (buttonState.value[0].isNotEmpty()) {
                    OnBoardingButton(
                        modifier = Modifier.fillMaxWidth(),
                        text = buttonState.value[0],
                        onClickButton = {
                            scope.launch {
                                if (pageState.currentPage == 2) {
                                    onEvent(OnBoardingEvent.SaveAppEntry)
                                } else {
                                    pageState.animateScrollToPage(
                                        page = pageState.currentPage + 1

                                    )
                                }
                            }
                        },

                    )
                }
            }
        }
    }
}
