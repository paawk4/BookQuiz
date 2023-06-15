package com.pawka.bookbythelinequiz.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.pawka.bookbythelinequiz.R
import com.pawka.bookbythelinequiz.navigation.AppNavHost
import com.pawka.bookbythelinequiz.navigation.Screen
import com.pawka.bookbythelinequiz.ui.theme.BookByTheLineQuizTheme
import com.pawka.bookbythelinequiz.ui.vm.QuizViewModel
import com.pawka.bookbythelinequiz.ui.vm.ViewModelFactory
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (application as QuizApplication).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)

        setContent {
            BookByTheLineQuizTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(Modifier.fillMaxWidth()) {
                        Box(contentAlignment = Alignment.TopCenter) {
                            Image(
                                painter = painterResource(id = R.drawable.books_bg),
                                contentDescription = null
                            )
                            Image(
                                painter = painterResource(id = R.drawable.books),
                                contentDescription = null,
                                modifier = Modifier.fillMaxWidth(),
                                contentScale = ContentScale.Crop,
                            )
                        }
                        val quizViewModel: QuizViewModel = viewModel(factory = viewModelFactory)
                        quizViewModel.getBooks()
                        quizViewModel.getThreeRandomBooks()
                        AppNavHost(
                            startDestination = Screen.Start.route,
                            quizViewModel = quizViewModel,
                            activity = this@MainActivity
                        )
                    }
                }
            }
        }
    }
}