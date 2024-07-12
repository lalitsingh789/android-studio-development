package com.example.json

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.json.ViewModels.ProductViewModel
import com.example.json.ViewModels.UserViewModel
import com.example.json.Views.ProductScreen
import com.example.json.Views.UserScreen
import com.example.json.model.data.Product
import kotlinx.coroutines.launch
import com.example.json.ui.theme.JsonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var value by remember { mutableFloatStateOf(0f) }
            var checked by remember { mutableStateOf(true) }
            val productVM : ProductViewModel by viewModels()
            val userVM : UserViewModel by viewModels()
            JsonTheme {
  //              UserScreen(userVM)
                ProductScreen(productVM)
//                Column(
//                    modifier = Modifier
//                        .padding(20.dp)
//                        .fillMaxSize(),
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.Center
//                ) {
//                    Button(onClick = {
//                        productVM.fetchProducts()
//                    }) {
//                        Text(text = "Click to make an API Call")
//                    }
//                }
            }
        }
    }
}



