package com.example.plsnoozeloo.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.inversePrimaryLight
import com.example.compose.primaryLight
import com.example.compose.secondaryLight
import com.example.ui.theme.AppTypography

@Composable
fun AlarmItemCard(
    title: String,
    time: String,
    period: String,
    isEnabled: Boolean,
    nextTrigger: String,
    onToggle: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(12.dp))
            .padding(16.dp)
    ){
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
           Row (
               modifier = Modifier
                   .fillMaxWidth(),
               horizontalArrangement = Arrangement.SpaceBetween,
               verticalAlignment = Alignment.CenterVertically
           ){
               Text(
                   text = title,
                   fontSize = 16.sp,
                   fontWeight = FontWeight.Medium,
                   style = AppTypography.labelLarge
               )
               Switch(
                   checked = isEnabled,
                   onCheckedChange = onToggle,
                   colors = SwitchDefaults.colors(
                       checkedTrackColor = primaryLight,
                       uncheckedTrackColor = inversePrimaryLight,
                       checkedThumbColor = Color.White,
                       uncheckedThumbColor = Color.White,
                       checkedBorderColor = Color.Transparent,
                       uncheckedBorderColor = Color.Transparent
                   )
               )
           }
           Row (
               verticalAlignment = Alignment.Bottom
           ){
               Text(
                   text = time,
                   fontSize = 42.sp,
                   fontWeight = FontWeight.Bold,
                   style = AppTypography.headlineLarge
               )
               Spacer(modifier = Modifier.width(6.dp))
               Text(
                   text = period,
                   fontSize = 24.sp,
                   fontWeight = FontWeight.Medium,
                   style = AppTypography.bodyMedium,
                   modifier = Modifier.padding(bottom = 6.dp)
               )
           }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = nextTrigger,
                fontSize = 14.sp,
                color = Color.Gray,
                style = AppTypography.labelSmall,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}

@Preview
@Composable
private fun AlarmItemCardPrev() {
    AlarmItemCard(
        title = "Wake Up",
        time = "10:30",
        period = "PM",
        isEnabled = false,
        onToggle = {},
        nextTrigger = "Alarm in 3 hours"
    )
}