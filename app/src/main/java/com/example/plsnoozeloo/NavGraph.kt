package com.example.plsnoozeloo

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.plsnoozeloo.presentation.AlarmList
import com.example.plsnoozeloo.presentation.screens.SplashScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            SplashScreen(onTimeOut =  {
                navController.navigate("alarm_list") {
                    popUpTo("splash"){inclusive = true}
                }
            })
        }
        composable("alarm_list") {
            AlarmList()
        }
    }
}