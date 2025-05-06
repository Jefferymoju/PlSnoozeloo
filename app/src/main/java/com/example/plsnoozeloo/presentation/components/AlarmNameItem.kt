package com.example.plsnoozeloo.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.compose.outlineVariantLight
import com.example.compose.primaryLight

@Composable
fun AlarmNameItem(
    modifier: Modifier = Modifier,
    currentName: String = "",
    onNameChanged: (String)  -> Unit = {}
) {
    var showDialogue by remember { mutableStateOf(false) }
    var newName by remember { mutableStateOf(currentName) }
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(16.dp))
            .padding(16.dp)
            .clickable { showDialogue = true },
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = "Alarm Name",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = if (currentName.isEmpty()) "Add Name" else currentName,
            fontSize = 14.sp,
            color = outlineVariantLight
        )
    }

    if (showDialogue) {
        Dialog(
            onDismissRequest = {showDialogue = false}
        ) {
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = Color.White
            ) {
                Column(
                    modifier = Modifier
                        .padding(24.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = "Alarm Name",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )

                    OutlinedTextField(
                        value = newName,
                        onValueChange = { newName = it },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("Enter alarm name") },
                        placeholder = { Text("My Alarm") },
                        singleLine = true
                    )

                    Row (
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        TextButton(
                            onClick = {showDialogue = false}
                        ) {
                            Text("Cancel")
                        }

                        Button(
                            onClick = {
                                if (newName.isNotBlank()) {
                                    onNameChanged(newName.trim())
                                    showDialogue = false
                                }
                            },
                            colors = ButtonDefaults.buttonColors(primaryLight),
                            enabled = newName.isNotBlank()
                        ) {
                            Text("Save")
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun AlarmNameItemPrev() {
    AlarmNameItem()
}