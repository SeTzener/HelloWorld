package com.example.helloworld.nested.navigation.example.nav_graph

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.helloworld.nested.navigation.example.DETAIL_ARGUMENT_KEY
import com.example.helloworld.nested.navigation.example.DETAIL_ARGUMENT_KEY2
import com.example.helloworld.nested.navigation.example.DetailScreen
import com.example.helloworld.nested.navigation.example.HOME_ROUTE
import com.example.helloworld.nested.navigation.example.HomeScreen
import com.example.helloworld.nested.navigation.example.Screen
import com.example.helloworld.screen.argumets.example.SECOND_ARGUMENT_KEY
import com.example.helloworld.screen.argumets.example.SECOND_ARGUMENT_KEY2

fun NavGraphBuilder.homeNavGraph(navController: NavController) {
    navigation(
        startDestination = Screen.Home.route,
        route = HOME_ROUTE
    ) {
        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(
                navArgument(DETAIL_ARGUMENT_KEY) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(DETAIL_ARGUMENT_KEY2) {
                    type = NavType.StringType
                }
            )
        ) {
            Log.d("Args", it.arguments?.getInt(SECOND_ARGUMENT_KEY).toString())
            Log.d("Args", it.arguments?.getString(SECOND_ARGUMENT_KEY2).toString())
            DetailScreen(navController = navController)
        }
    }
}