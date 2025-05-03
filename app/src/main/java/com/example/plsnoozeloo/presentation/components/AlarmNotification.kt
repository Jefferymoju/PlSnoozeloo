package com.example.plsnoozeloo.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.primaryLight
import com.example.plsnoozeloo.R
import com.example.ui.theme.AppTypography

@Composable
fun AlarmNotification(
    title: String,
    time: String,
    onClick : () -> Unit,
    modifier: Modifier = Modifier
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = R.drawable.clock_icon),
            contentDescription = "Clock_Icon",
            colorFilter = ColorFilter.tint(primaryLight),
            modifier = Modifier
                .size(60.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = time,
            fontSize = 75.sp,
            color = primaryLight,
            fontWeight = FontWeight.Bold,
            style = AppTypography.headlineLarge
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            style = AppTypography.labelLarge
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            modifier = Modifier
                .padding(8.dp)
                .size(width = 214.dp, height = 45.dp),
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(primaryLight)
        ) {
            Text(
                text = "Turn Off",
                fontSize = 20.sp,
                style = AppTypography.labelSmall
            )
        }
    }
}

@Preview
@Composable
private fun AlarmNotificationPrev() {
    AlarmNotification(
        title = "Wake Up",
        time = "10:30",
        onClick = {}
    )
}