package com.example.pdd_compose.presentation.profile

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.pdd_compose.R
import com.example.pdd_compose.presentation.profile.component.ProfileComponent
import com.example.pdd_compose.util.Resource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = hiltViewModel(),
    navController: NavController,
) {
    val sheetState = rememberModalBottomSheetState(true)
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        Log.d("ProfileScreen", "Calling loadProfile()")
        viewModel.loadProfile()
    }

    val profileState by viewModel.profile.collectAsState()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.onboarding_backround)),
        ) {
            when (profileState) {
                is Resource.Loading -> {
                    Log.d("ProfileScreen", "Loading profile data...")
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(160.dp),
                            color = Color.Red,
                            strokeWidth = 12.dp
                        )
                    }
                }
                is Resource.Success -> {
                    Log.d("ProfileScreen", "Profile data loaded successfully")
                    val profileData = (profileState as Resource.Success).data
                    ProfileComponent(

                        onEditClick = {  },
                        onClickDelete = {  },
                        rank = profileData?.rank.toString(),
                        score = profileData!!.point_count,
                        nextRank = profileData.next_rank.toString(),
                        progress = profileData.completed_lesson!!.div(6f),
                        point = profileData.completed_test.toString(),
                        point1 = profileData.completed_lesson.toString(),
                        point2 = profileData.point_count.toString(),
                        name = profileData.user.toString(),
                        img = profileData.image
                    )
                }
                is Resource.Error -> {
                    val errorMessage = (profileState as Resource.Error).message
                    Log.e("ProfileScreen", "Error loading profile: $errorMessage")
                }
                is Resource.Empty -> {

                }
            }
        }
    }
