package com.example.helloworld.screen.argumets.example

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.helloworld.navController2

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController2,
        startDestination =  Screen.First.route,
    ) {
        composable(
            route = Screen.First.route
        ) {
            FirstScreen(navController = navController2)
        }
        composable(
            route = Screen.Second.route,
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