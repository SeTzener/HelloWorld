package com.example.helloworld.alternative.nested.navigation.example.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.helloworld.alternative.nested.navigation.example.screens.HOME_ROUTE2
import com.example.helloworld.alternative.nested.navigation.example.screens.ROOT_ROUTE2

@Composable
fun setupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = HOME_ROUTE2,
        route = ROOT_ROUTE2
    ) {
        homeNavGraph(navController = navController)
        authNavGraph(navController = navController)
    }
}