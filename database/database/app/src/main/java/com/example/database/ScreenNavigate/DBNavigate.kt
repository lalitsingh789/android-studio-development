package com.example.database.ScreenNavigate

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.database.Screen.AddScreen
import com.example.database.Screen.DeleteScreen
import com.example.database.Screen.MainScreen
import com.example.database.Screen.ReadScreen
import com.example.database.Screen.UpdateScreen

@Composable
fun DBNavigate(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Main Screen") {
        composable("Main Screen") { MainScreen(navController) }
        composable("CreateScreen") {AddScreen(navController)}
        composable("ReadScreen") { ReadScreen(navController) }
        composable("UpdateScreen") { UpdateScreen(navController) }
        composable("DeleteScreen") {DeleteScreen(navController)}
    }
}