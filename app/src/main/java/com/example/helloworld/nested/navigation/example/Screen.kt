package com.example.helloworld.nested.navigation.example

const val DETAIL_ARGUMENT_KEY = "id"
const val DETAIL_ARGUMENT_KEY2 = "name"
const val AUTHENTICATION_ROUTE = "authentication"
const val HOME_ROUTE = "home"
const val ROOT_ROUTE = "root"
sealed class Screen(val route: String) {
    data object Home: Screen(route = "home_screen")

    data object Detail: Screen(route = "detail_screen?id={$DETAIL_ARGUMENT_KEY}&name={$DETAIL_ARGUMENT_KEY2}") {
        fun passNameAndId(
            id: Int = 0,
            name: String = "Detail"
        ): String {
            return "detail_screen?id=$id&name=$name"
        }
    }

    data object Login: Screen(route = "login_screen")
    data object Signup: Screen(route = "signup_screen")
}