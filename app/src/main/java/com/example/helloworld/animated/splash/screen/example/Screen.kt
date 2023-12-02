package com.example.helloworld.animated.splash.screen.example

import androidx.navigation.NavController


sealed class Screen(val route: String) {
    data object Home: Screen(route = "home_screen")
    data object Splash: Screen(route = "splash_screen")
}