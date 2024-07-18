package com.example.database.Screen


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.database.CRUD.deleteUser


@Composable
fun DeleteScreen(navController: NavController){
    var gender by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp),
        contentAlignment = Alignment.Center
    ) {
        ElevatedCard(
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            modifier = Modifier.padding(25.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFEFF4FA))
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(20.dp)
            ) {
                OutlinedTextField(
                    value = gender,
                    onValueChange = { gender = it },
                    modifier = Modifier
                        .padding(vertical = 10.dp)
                        .fillMaxWidth(),
                    label = { Text("GENDER") }
                )
                Button(
                    onClick = { deleteUser(gender) },
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .fillMaxWidth()
                ) {
                    Text(text = "Delete gender", fontSize = 16.sp)
                }
            }
        }
    }
}
