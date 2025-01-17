package com.example.pdd_compose.presentation.nav_graph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.pdd_compose.presentation.navigator.Navigator
import com.example.pdd_compose.presentation.register.RegisterScreen
import com.example.pdd_compose.presentation.register.onboarding.OnBoardingScreen
import com.example.pdd_compose.presentation.register.onboarding.OnBoardingViewModel

@Composable
fun NavGraph(
    startDestination:String
) {

    val navController = rememberNavController()

    NavHost(
        navController = navController ,
        startDestination = startDestination) {

        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ) {
            composable(route = Route.OnBoardingScreen.route){
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(
                    onEvent = viewModel::onEvent
                )
            }
        }
        navigation(
            route = Route.AuthNavigation.route,
            startDestination = Route.RegisterScreen.route
        ) {
            composable(route = Route.RegisterScreen.route){
                RegisterScreen(navController = navController)
            }
        }

        navigation(
            route = Route.PddNavigation.route,
            startDestination = Route.PddNavigationScreen.route
            ) {
            composable(route = Route.PddNavigationScreen.route) {
                Navigator()
            }
        }
    }

}