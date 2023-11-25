package com.example.helloworld.alternative.nested.navigation.example.nav_graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.helloworld.alternative.nested.navigation.example.screens.AUTHENTICATION_ROUTE2
import com.example.helloworld.alternative.nested.navigation.example.screens.LoginScreen
import com.example.helloworld.alternative.nested.navigation.example.screens.Screen
import com.example.helloworld.alternative.nested.navigation.example.screens.SignupScreen

fun NavGraphBuilder.authNavGraph(navController: NavController) {
    navigation(
        startDestination = Screen.Login.route,
        route = AUTHENTICATION_ROUTE2
    ) {
        composable(route = Screen.Login.route){
            LoginScreen(navController = navController)
        }
        composable(route = Screen.Signup.route) {
            SignupScreen(navController = navController)
        }
    }
}