package com.example.helloworld.alternative.nested.navigation.example.nav_graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.helloworld.alternative.nested.navigation.example.screens.DetailScreen
import com.example.helloworld.alternative.nested.navigation.example.screens.HOME_ROUTE2
import com.example.helloworld.alternative.nested.navigation.example.screens.HomeScreen
import com.example.helloworld.alternative.nested.navigation.example.screens.Screen

fun NavGraphBuilder.homeNavGraph(navController: NavController) {
    navigation(
        startDestination = Screen.Home.route,
        route = HOME_ROUTE2
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.Detail.route) {
            DetailScreen(navController = navController)
        }
    }
}