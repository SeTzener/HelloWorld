package com.example.helloworld

sealed class Screen(val route: String) {
    data object Home : Screen(route = "home_screen")
    data object Detail : Screen(route = "detail-screen")
}

const val SECOND_ARGUMENT_KEY = "id"
const val SECOND_ARGUMENT_KEY2 = "name"

sealed class Screen2(val route: String) {
    data object First : Screen2(route = "first_screen")
    data object Second : Screen2(route = "second_screen?id={$SECOND_ARGUMENT_KEY}&name={$SECOND_ARGUMENT_KEY2}") {
//            object Second: Screen(route = "second_screen/{$SECOND_ARGUMENT_KEY}/{$SECOND_ARGUMENT_KEY2}") {
        fun passId(id: Int): String {
            return "second_screen?id=$SECOND_ARGUMENT_KEY"
//            return this.route.replace("{$SECOND_ARGUMENT_KEY}", id.toString())
        }

        fun passNameAndId(
            id: Int = 0,
            name: String = "Tano"
        ): String {
            return "second_screen?id=$id&name=$name"
//            return this.passId(id).replace("{$SECOND_ARGUMENT_KEY2}", name)
        }
    }
}