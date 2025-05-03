package com.example.plsnoozeloo.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.primaryLight
import com.example.plsnoozeloo.R
import com.example.ui.theme.AppTypography

@Composable
fun EmptyAlarmScreen(modifier: Modifier = Modifier) {
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.clock_icon),
                contentDescription = "Clock_Icon",
                colorFilter = ColorFilter.tint(primaryLight),
                modifier = Modifier
                    .size(60.dp)
            )
            Spacer(modifier = Modifier.height(25.dp))
            Text(
                text = "It's empty! Add the first alarm so you don't miss an important moment",
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(16.dp),
                style = AppTypography.bodyMedium
            )
        }
    }
}

@Preview
@Composable
private fun EmptyAlarmScreenPrev() {
    EmptyAlarmScreen()
}