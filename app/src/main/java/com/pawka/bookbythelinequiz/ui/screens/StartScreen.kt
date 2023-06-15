package com.pawka.bookbythelinequiz.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.pawka.bookbythelinequiz.R
import com.pawka.bookbythelinequiz.navigation.Screen
import com.pawka.bookbythelinequiz.ui.theme.Blau
import com.pawka.bookbythelinequiz.ui.theme.Orange

@Composable
fun StartScreen(navController: NavHostController) {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.start_text),
            color = Blau,
            fontSize = 46.sp,
            textAlign = TextAlign.Center,
            minLines = 3,
            maxLines = 3,
            lineHeight = 50.sp,
            fontFamily = FontFamily(Font(R.font.oswald_medium))
        )
        Button(
            modifier = Modifier
                .width(300.dp)
                .height(65.dp),
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Orange),
            onClick = {
                navController.navigate(Screen.Quiz.route) {
                    launchSingleTop = true
                }
            },
        ) {
            Text(
                text = stringResource(R.string.play_btn_text),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
