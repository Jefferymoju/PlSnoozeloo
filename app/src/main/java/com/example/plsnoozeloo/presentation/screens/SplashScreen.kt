package com.example.plsnoozeloo.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.compose.primaryLight
import com.example.plsnoozeloo.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    onTimeOut : () -> Unit
) {
    LaunchedEffect(Unit) {
        delay(2000L)
        onTimeOut()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = primaryLight),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.clock_icon),
            contentDescription = "Clock_Icon",
            modifier = Modifier.size(100.dp)
        )
    }
}