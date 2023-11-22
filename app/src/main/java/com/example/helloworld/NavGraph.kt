package com.example.helloworld

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navController)
        }
        composable(
            route = Screen.Detail.route
        ) {
            DetailScreen(navController)
        }
    }
}

@Composable
fun SetupSecondNavGraph(
    navController2: NavHostController
) {
    NavHost(
        navController = navController2,
        startDestination =  Screen2.First.route,
    ) {
        composable(
            route = Screen2.First.route
        ) {
            FirstScreen(navController = navController2)
        }
        composable(
            route = Screen2.Second.route,
            arguments = listOf(
                navArgument(name = SECOND_ARGUMENT_KEY) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(name = SECOND_ARGUMENT_KEY2) {
                    type = NavType.StringType
                }
            )
        ) {
            Log.d("Args", it.arguments?.getInt(SECOND_ARGUMENT_KEY).toString())
            Log.d("Args", it.arguments?.getString(SECOND_ARGUMENT_KEY2).toString())
            SecondScreen(navController = navController2)
        }
    }
}