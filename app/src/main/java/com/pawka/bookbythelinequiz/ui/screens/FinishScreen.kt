package com.pawka.bookbythelinequiz.ui.screens

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pawka.bookbythelinequiz.R
import com.pawka.bookbythelinequiz.domain.model.ResultBook
import com.pawka.bookbythelinequiz.ui.MainActivity
import com.pawka.bookbythelinequiz.ui.theme.Blau
import com.pawka.bookbythelinequiz.ui.theme.GreenRight
import com.pawka.bookbythelinequiz.ui.theme.Orange
import com.pawka.bookbythelinequiz.ui.theme.RedWrong
import com.pawka.bookbythelinequiz.ui.vm.QuizViewModel

@Composable
fun FinishScreen(quizViewModel: QuizViewModel, activity: MainActivity) {
    LazyColumn(
        Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, bottom = 15.dp)
    ) {
        item {
            Text(
                text = stringResource(R.string.results_text),
                color = Blau,
                fontSize = 36.sp,
                fontFamily = FontFamily(Font(R.font.oswald_medium))
            )
        }
        items(quizViewModel.resultList) {
            ResultListItem(it)
        }
    }
}

@Composable
fun ResultListItem(book: ResultBook) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(color = if (book.imageRightBook == book.imageSelectedBook) GreenRight else RedWrong),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(R.string.book_text),
            color = Color.White,
            fontWeight = FontWeight.W600,
        )
        Image(
            painterResource(id = book.imageRightBook),
            contentDescription = null,
            modifier = Modifier.fillMaxHeight(),
            contentScale = ContentScale.FillHeight
        )
        Text(
            text = stringResource(R.string.you_have_chosen_text),
            color = Color.White,
            fontWeight = FontWeight.W600,
        )
        Image(
            painterResource(id = book.imageSelectedBook),
            contentDescription = null,
            modifier = Modifier.fillMaxHeight(),
            contentScale = ContentScale.FillHeight
        )
    }
}