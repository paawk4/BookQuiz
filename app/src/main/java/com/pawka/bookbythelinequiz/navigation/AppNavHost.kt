package com.pawka.bookbythelinequiz.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pawka.bookbythelinequiz.ui.MainActivity
import com.pawka.bookbythelinequiz.ui.screens.FinishScreen
import com.pawka.bookbythelinequiz.ui.screens.QuizScreen
import com.pawka.bookbythelinequiz.ui.screens.StartScreen
import com.pawka.bookbythelinequiz.ui.vm.QuizViewModel

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String,
    quizViewModel: QuizViewModel,
    activity: MainActivity
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(Screen.Start.route) {
            StartScreen(navController)
        }
        composable(Screen.Quiz.route) {
            navController.enableOnBackPressed(false)
            QuizScreen(navController, quizViewModel)
        }
        composable(Screen.Finish.route) {
            navController.enableOnBackPressed(false)
            FinishScreen(quizViewModel, activity)
        }
    }
}