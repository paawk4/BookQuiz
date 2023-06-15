package com.pawka.bookbythelinequiz.navigation

sealed class Screen(val route: String) {
    object Start : Screen("start")
    object Quiz : Screen("quiz")
    object Finish : Screen("finish")
}
