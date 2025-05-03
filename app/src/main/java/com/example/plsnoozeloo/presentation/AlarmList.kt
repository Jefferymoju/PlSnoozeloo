package com.example.plsnoozeloo.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.primaryLight
import com.example.plsnoozeloo.presentation.components.AlarmItemCard
import com.example.plsnoozeloo.presentation.components.EmptyAlarmScreen
import com.example.ui.theme.AppTypography

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AlarmList(modifier: Modifier = Modifier) {
   val toggleState = remember { List(12) {mutableStateOf(false) }}
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Your Alarms",
                        textAlign = TextAlign.Left,
                        fontSize = 25.sp,
                        style = AppTypography.headlineLarge
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                shape = CircleShape,
                containerColor = primaryLight
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Icon",
                    tint = Color.White,
                    modifier = Modifier
                        .size(30.dp)
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
    ){ innerPadding ->
        LazyColumn (
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ){
            items(12){ index ->
                AlarmItemCard(
                    title = "Alarm $index",
                    time = "10:${(index % 60).toString().padStart(2, '0')}",
                    period = if (index % 2 == 0) "AM" else "PM",
                    isEnabled = toggleState[index].value,
                    nextTrigger = "Alarm in ${index + 5} min",
                    onToggle = { newValue ->
                        toggleState[index].value = newValue
                    }
                )
            }
        }
//        EmptyAlarmScreen()

    }
}

@Preview
@Composable
fun AlarmListPrev(modifier: Modifier = Modifier) {
    AlarmList()
}