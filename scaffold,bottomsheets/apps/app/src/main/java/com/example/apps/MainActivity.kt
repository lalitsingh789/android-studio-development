package com.example.apps

import android.app.AlertDialog
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.apps.ui.theme.AppsTheme
import androidx.compose.material3.Icon as Icon1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            AppsTheme {
                ScaffoldExample()
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {

    Scaffold(topBar = {
        TopAppBar(colors = topAppBarColors(
        containerColor = MaterialTheme.colorScheme.primary,
        titleContentColor = MaterialTheme.colorScheme.error
    ),
            title = { Text(text = "TOP BAR") }
            )
    },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.error
            ){
                Text(text = "BOTTOM BAR",
                    fontSize = 24.sp
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                println("FAB Clicked!")
            }) {
                Icon1(Icons.Filled.Add, contentDescription = "ADD CHAT")
            }
        }

    ) { innerpadding ->
        var sheetState = rememberModalBottomSheetState()
        var showButtonSheet by remember {
            mutableStateOf(false)
        }
        var showAlert by remember{
            mutableStateOf(false)
        }
        var text by remember {
            mutableStateOf("")
        }

        Column(modifier = Modifier.padding(innerpadding))
        {
        Text(text = "this is my scaffold area where anything i can put")
         Button(onClick = { showButtonSheet = true },
             modifier = Modifier
                 .align(Alignment.CenterHorizontally)
                 .padding(16.dp)
             ) {
             Text(text = "Show bottom sheet")
         }
            Button(onClick ={showAlert=true},
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
            )

            {
                Text(text = "show alert")
            }
            TextField(
                value = text,
                onValueChange = { text = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                label = { Text("Enter something") }
            )

        }

        if(showAlert){
            AlertDialogExample()
        }
        if(showButtonSheet){
            ModalBottomSheet(
                onDismissRequest = { showButtonSheet = false},
                sheetState= sheetState,
                containerColor = MaterialTheme.colorScheme.error
            ) {
                Column(modifier = Modifier
                    .padding(15.dp)
                    .fillMaxSize()) {
                    Text(text = "Hi!! MY NAME IS BOT")
                }
            }
        }

        }
    }



@Composable
fun AlertDialogExample(){
    AlertDialog(
        icon = { Icon(Icons.Filled.Info, contentDescription = "DONE")},
        title = { Text(text = "EMERGENCY")},
        text = {
            Text(text = "This will reset your device to its default settings")
        },
        onDismissRequest = { /*TODO*/ },
        confirmButton = {
            Button(
                onClick = {
                    println("You are confirmed to go")
                }
            ) {
                Text("Confirm")
            }
        },
        dismissButton = {
            Button(
                onClick = { /*TODO*/ }
            ) {
                Text("Cancel")

            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun AlertDialogExamplepreview(){
    AlertDialogExample()
}

@Preview(showBackground = true)
@Composable
fun ScaffoldExamplePreview() {
    AppsTheme {
        ScaffoldExample()
    }
}
