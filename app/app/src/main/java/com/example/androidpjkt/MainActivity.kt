package com.example.androidpjkt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidpjkt.ui.theme.AndroidpjktTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidpjktTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Tell them to put some sunglasses",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val gradientColors = listOf(Color(0xFF00FFFF), Color(0xFF87CEEB), Color(0xFF8A2BE2))

    AndroidpjktTheme  {
        Text(
            text = "Do not allow people to dim your shine because they are blinded. $name",
            style = TextStyle(
                fontSize = 45.sp,
                brush = Brush.linearGradient(
                    colors = gradientColors,
                    start = Offset(0f, 0f),
                    end = Offset(Float.POSITIVE_INFINITY, 0f)
                )
            ),
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        )
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidpjktTheme{
        Greeting("Tell them to put some sunglasses")
    }
}