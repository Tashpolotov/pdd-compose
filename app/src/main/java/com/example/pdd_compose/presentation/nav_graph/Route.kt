package com.example.pdd_compose.presentation.nav_graph

sealed class Route (val route:String){

    object OnBoardingScreen:Route(route = "onBoardingScreen")
    object HomeScreen:Route(route = "homeScreen")
    object VideoScreen:Route(route = "videoScreen")
    object RankScreen:Route(route = "rankScreen")
    object ProfileScreen:Route(route = "profileScreen")
    object RegisterScreen:Route(route = "registerScreen")
    object AppStartNavigation:Route(route = "appStartNavigation")
    object PddNavigation:Route(route = "pddNavigation")
    object PddNavigationScreen:Route(route = "pddNavigationScreen")
    object AuthNavigation:Route(route = "authNavigation")

}
