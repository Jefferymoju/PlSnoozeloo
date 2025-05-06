package com.example.plsnoozeloo.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.outlineVariantLight
import com.example.compose.surfaceContainerLowLight
import com.example.plsnoozeloo.presentation.components.AlarmNameItem


@Composable
fun AlarmSetupScreen(modifier: Modifier = Modifier) {
    var hour by remember { mutableStateOf("") }
    var minute by remember { mutableStateOf("") }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(surfaceContainerLowLight)
            .padding(18.dp)
    ){
        CloseAndSave(
            onSave = {},
            onClose = {}
        )
        Spacer(modifier = Modifier.height(16.dp))
        HourAndMinuteInput(
            hour = hour,
            onHourChange = { hour = it },
            minute = minute,
            onMinuteChange = { minute = it },
            alarmLabel = "Alarm in 7 hours"
        )
        Spacer(modifier = Modifier.height(16.dp))
        AlarmNameItem()
    }
}

@Composable
fun CloseAndSave(
    onClose: () -> Unit,
    onSave: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        IconButton(
            onClick = {onClose()},
            modifier = Modifier
                .background(outlineVariantLight, RoundedCornerShape(12.dp))
        ) {
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = "close icon",
                tint = Color.White
            )
        }

        Button(
            onClick = {onSave()},
            colors = ButtonDefaults.buttonColors(outlineVariantLight)
        ) {
            Text(
                text = "Save",
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun HourAndMinuteInput(
    hour: String,
    onHourChange: (String) -> Unit,
    minute: String,
    onMinuteChange : (String) -> Unit,
    alarmLabel: String,
    modifier: Modifier = Modifier
) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(16.dp))
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            TimeInputField(
                value = hour,
                onValueChanged = onHourChange,
                label = "00",
                modifier = Modifier.weight(1f)
            )
            Text(
                text = ":",
                fontWeight = FontWeight.Medium,
                fontSize = 30.sp
            )
            TimeInputField(
                value = minute,
                onValueChanged = onMinuteChange,
                label = "00",
                modifier = Modifier.weight(1f)
            )
        }
        Text(
            text = alarmLabel,
            fontSize = 14.sp,
        )
    }
}

@Composable
fun TimeInputField(
    value: String,
    onValueChanged : (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange = {newValue ->
            if (newValue.length <= 2 && (newValue.isEmpty() || newValue.all { it.isDigit() })){
                onValueChanged(newValue)
            }
        },
        textStyle = TextStyle(
            fontSize = 52.sp,
            textAlign = TextAlign.Center
        ),
        placeholder = {
            Text(
                text = label,
                fontSize = 52.sp,
                textAlign = TextAlign.Center,
                modifier = modifier.fillMaxWidth()
            )
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number
        ),
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.colors(
            disabledContainerColor = outlineVariantLight,
            focusedContainerColor = outlineVariantLight,
            unfocusedContainerColor = outlineVariantLight,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        singleLine = true,
        modifier = modifier
            .padding(8.dp)
    )
}


@Preview
@Composable
private fun AlarmSetupScreenPrev() {
    AlarmSetupScreen()
}

//@Preview
//@Composable
//private fun CloseAndSavePrev() {
//    CloseAndSave()
//}

//@Preview
//@Composable
//private fun HourAndMinuteInputPrev() {
//    HourAndMinuteInput()
//}