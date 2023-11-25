package com.example.helloworld.nested.navigation.example.nav_graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.helloworld.nested.navigation.example.AUTHENTICATION_ROUTE
import com.example.helloworld.nested.navigation.example.LoginScreen
import com.example.helloworld.nested.navigation.example.Screen
import com.example.helloworld.nested.navigation.example.SignupScreen

fun NavGraphBuilder.authNavGraph(navController: NavController) {
    navigation(
        startDestination = Screen.Login.route,
        route = AUTHENTICATION_ROUTE
    ) {
        composable(
            route = Screen.Login.route
        ) {
            LoginScreen(navController = navController)
        }
        composable(route = Screen.Signup.route) {
            SignupScreen(navController = navController)
        }
    }
}