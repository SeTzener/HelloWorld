package com.example.helloworld.alternative.nested.navigation.example.screens

const val AUTHENTICATION_ROUTE2 = "authentication"
const val HOME_ROUTE2 = "home"
const val ROOT_ROUTE2 = "root"
sealed class Screen(val route: String) {
    data object Home: Screen(route = "home_screen")
    data object Detail: Screen(route = "detail_screen")
    data object Login: Screen(route = "login_screen")
    data object Signup: Screen(route = "signup_screen")
}