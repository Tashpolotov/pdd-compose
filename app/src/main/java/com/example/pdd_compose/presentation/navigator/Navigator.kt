package com.example.pdd_compose.presentation.navigator

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pdd_compose.R
import com.example.pdd_compose.presentation.main.HomeScreen
import com.example.pdd_compose.presentation.nav_graph.Route
import com.example.pdd_compose.presentation.navigator.component.BottomNavigationItem
import com.example.pdd_compose.presentation.navigator.component.NewsBottomNavigation
import com.example.pdd_compose.presentation.profile.ProfileScreen
import com.example.pdd_compose.presentation.rank.RankScreen
import com.example.pdd_compose.presentation.video.VideoScreen

@Composable
fun Navigator() {
    val bottomNavigationItems = remember {
        listOf(
            BottomNavigationItem(icon = R.drawable.ic_home, "Home"),
            BottomNavigationItem(icon = R.drawable.ic_video, "Video"),
            BottomNavigationItem(icon = R.drawable.ic_rating, "Rating"),
            BottomNavigationItem(icon = R.drawable.ic_profile, "Profile")
        )
    }
    val navController = rememberNavController()
    val backStackState = navController.currentBackStackEntryAsState().value
    var selectedItem by rememberSaveable {
        mutableStateOf(0)
    }

    val isBottomBarVisible = remember(key1 = backStackState){
        backStackState?.destination?.route == Route.HomeScreen.route ||
                backStackState?.destination?.route == Route.VideoScreen.route ||
                backStackState?.destination?.route == Route.RankScreen.route ||
                backStackState?.destination?.route == Route.ProfileScreen.route

    }

    selectedItem = remember(key1 = backStackState) {

        when (backStackState?.destination?.route) {
            Route.HomeScreen.route -> 0
            Route.VideoScreen.route -> 1
            Route.RankScreen.route -> 2
            Route.ProfileScreen.route -> 3
            else -> 0
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if(isBottomBarVisible){
                NewsBottomNavigation(
                    items = bottomNavigationItems,
                    selected = selectedItem,
                    onItemClick = { index ->
                        when (index) {
                            0 -> navigateToTap(
                                navController = navController,
                                route = Route.HomeScreen.route
                            )

                            1 -> navigateToTap(
                                navController = navController,
                                route = Route.VideoScreen.route
                            )

                            2 -> navigateToTap(
                                navController = navController,
                                route = Route.RankScreen.route
                            )
                            3 -> navigateToTap(
                                navController = navController,
                                route = Route.ProfileScreen.route
                            )
                        }

                    }
                )
            }
        }
    ) {

        val bottomPadding = it.calculateBottomPadding()
        NavHost(
            navController = navController,
            startDestination = Route.HomeScreen.route,
            modifier = Modifier.padding(bottom = bottomPadding)
        ) {
            composable(route = Route.HomeScreen.route) {
                HomeScreen(

                )
            }
            composable(route = Route.VideoScreen.route) {
                VideoScreen()
            }


            composable(route = Route.RankScreen.route) {
            RankScreen()

            }
            composable(route = Route.ProfileScreen.route) {
            ProfileScreen(navController = navController)

            }

        }
    }

}

fun navigateToTap(navController: NavController, route: String) {
    Log.d("Navigator", "Navigating to: $route")

    navController.navigate(route) {
        navController.graph.startDestinationRoute?.let { homeScreen ->
            popUpTo(homeScreen) {
                saveState = true
            }
            restoreState = true
            launchSingleTop = true
        }
    }
}
