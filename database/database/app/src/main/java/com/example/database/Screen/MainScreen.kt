package com.example.database.Screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MainScreen(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp),
        contentAlignment = Alignment.Center
    ){
        Column{
            Button(
                onClick = { navController.navigate("CreateScreen") },
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
            ){
                Text(text = "Create/Add User", fontSize = 16.sp)
            }
            Button(
                onClick = { navController.navigate("ReadScreen") },
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
            ){
                Text(text = "Read User", fontSize = 16.sp)
            }
            Button(
                onClick = { navController.navigate("UpdateScreen") },
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
            )
            {
                Text(text = "Update User", fontSize = 16.sp)
            }
            Button(onClick = {navController.navigate("DeleteScreen")},
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth())
            {
                Text(text = "Delete User", fontSize = 16.sp)
            }
        }

    }

}