package com.example.database.Screen


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.database.CRUD.readUser
import com.example.database.Model.User


@Composable
fun ReadScreen(navController: NavController) {
    var userList by remember { mutableStateOf<List<User>>(emptyList()) }
    LaunchedEffect(Unit) {
        readUser { userList = it }
    }
    readUser { userList = it }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp)
    ) {
        items(userList) { user ->
            Text(text = "Name: ${user.name} , Age:  ${user.age}")

        }
    }
}