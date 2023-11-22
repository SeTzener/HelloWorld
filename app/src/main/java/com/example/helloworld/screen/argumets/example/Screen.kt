package com.example.helloworld.screen.argumets.example

const val SECOND_ARGUMENT_KEY = "id"
const val SECOND_ARGUMENT_KEY2 = "name"

sealed class Screen(val route: String) {
    data object First : Screen(route = "first_screen")
    data object Second : Screen(route = "second_screen?id={$SECOND_ARGUMENT_KEY}&name={$SECOND_ARGUMENT_KEY2}") {
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