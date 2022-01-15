package com.amicum.utils

sealed class Screen(val route: String) {
    object TestWorkScreen : Screen("test_screen")
}

object Arg {
    const val comment = "comment"
}