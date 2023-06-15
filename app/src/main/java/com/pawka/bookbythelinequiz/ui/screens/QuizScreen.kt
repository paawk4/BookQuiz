package com.pawka.bookbythelinequiz.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.pawka.bookbythelinequiz.R
import com.pawka.bookbythelinequiz.domain.model.Book
import com.pawka.bookbythelinequiz.navigation.Screen
import com.pawka.bookbythelinequiz.ui.theme.Blau
import com.pawka.bookbythelinequiz.ui.vm.QuizViewModel
import com.pawka.bookbythelinequiz.ui.vm.QuizViewModel.Companion.UNSELECTED_ITEM

@Composable
fun QuizScreen(navController: NavHostController, viewModel: QuizViewModel) {
    val randomBooks = viewModel.randomBooks.observeAsState(listOf())

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val rightAnswer = viewModel.rightAnswer.observeAsState(Book(-1, "", -1))
        Text(
            text = rightAnswer.value.text,
            color = Blau,
            fontSize = 18.sp,
            fontWeight = FontWeight.W600,
            textAlign = TextAlign.Center,
            lineHeight = 20.sp,
            modifier = Modifier.padding(horizontal = 30.dp)
        )

        val selectedBookId = viewModel.selectedBookId.observeAsState(UNSELECTED_ITEM)


        LazyRow(
            Modifier
                .fillMaxWidth()
                .padding(top = 15.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(randomBooks.value) {
                QuizImageItem(it) { id, focus ->
                    viewModel.selectedBookId.value = id
                    viewModel.setFocusManager(focus)
                }
            }
        }

        Row(
            Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(top = 20.dp, end = 15.dp, bottom = 15.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Bottom
        ) {
            if (selectedBookId.value != UNSELECTED_ITEM) {
                Button(
                    onClick = {
                        viewModel.getNewRandomBooks {
                            navController.navigate(Screen.Finish.route)
                        }
                    },
                    modifier = Modifier.height(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Blau)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_next),
                        contentDescription = null
                    )
                }
            }


        }
    }
}

@Composable
fun QuizImageItem(book: Book, onClick: (Int, FocusManager) -> Unit) {
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current

    var border by remember {
        mutableStateOf(-1)
    }
    Image(
        painter = painterResource(id = book.image),
        contentDescription = null,
        modifier = Modifier
            .height(140.dp)
            .clickable {
                focusRequester.requestFocus()
                onClick(book.id, focusManager)
            }
            .border(border.dp, Blau)
            .focusRequester(focusRequester)
            .onFocusChanged { border = if (it.isFocused) 4 else -1 }
            .focusable(),
        contentScale = ContentScale.FillHeight,
    )
}


