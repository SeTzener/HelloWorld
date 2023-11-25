package com.example.helloworld.nested.navigation.example.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.helloworld.nested.navigation.example.HOME_ROUTE
import com.example.helloworld.nested.navigation.example.ROOT_ROUTE
import com.example.helloworld.nested.navigation.example.Screen

@Composable
fun setupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = HOME_ROUTE,
        route = ROOT_ROUTE
        ) {
        homeNavGraph(navController)
        authNavGraph(navController)
    }
}