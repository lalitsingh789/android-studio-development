package com.example.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigation.ui.theme.NavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            var text by remember {
                mutableStateOf("")
            }
            NavigationTheme {
            AppNavigation()
            }

        }
    }
}
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Screen1") {
        composable("Screen1") { Screen1(navController) }
        composable("Screen2") { Screen2(navController) }
        composable("Screen3") { Screen3(navController) }
    }
}

@Composable
fun Screen1(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp)
    ) {
        Button(onClick = { navController.navigate("Screen2") }) {
            Text(text = "List")
        }
        Button(onClick = { navController.navigate("Screen3") }) {
            Text(text = "Grid")
        }
    }
}

@Composable
fun Screen2(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(onClick = { navController.popBackStack("Screen1", false) }) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
        }
        Text(text = "List")
        val itemsList = List(50) { "Item : $it" }
        LazyColumn(
            modifier = Modifier
                .height(400.dp)
                .width(200.dp)
                .padding(5.dp)
                .border(2.dp, Color.Black)
        ) {
            items(itemsList.size) { index ->
                Text(text = itemsList[index], modifier = Modifier.padding(2.dp))
            }
        }
    }
}

@Composable
fun Screen3(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(onClick = { navController.popBackStack("Screen1", false) }) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
        }
        Text(text = "Grid")
        val itemsList = List(50) { "Item : $it" }
        LazyVerticalGrid(
            columns = GridCells.Adaptive(100.dp),
            modifier = Modifier
                .height(500.dp)
                .padding(2.dp)
                .border(2.dp, Color.Black)
        ) {
            items(itemsList.size) { index ->
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .border(1.dp, Color.Gray)
                        .padding(8.dp)
                ) {
                    Text(text = itemsList[index])
                }
            }
        }
    }
}
