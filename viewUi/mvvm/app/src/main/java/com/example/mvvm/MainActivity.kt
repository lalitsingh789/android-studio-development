package com.example.mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel


import com.example.mvvm.ui.theme.MvvmTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContent {
            val viewModel: CounterViewModel by viewModels()
            MvvmTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CounterView(counterVM = viewModel)
                }
            }
        }
    }
}

@Composable
fun CounterView(counterVM: CounterViewModel) {
    val counterState = counterVM.counter.value
    val intContent = GenericClass(120)
    val stringContent =GenericClass("hello generics")

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Current counter value: ${counterState.count}")
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = { counterVM.incrementCounter() }) {
                Text(text = "Increment")
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(onClick = { counterVM.decrementCounter() }) {
                Text(text = "Decrement")
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = {
                counterVM.resetCounter()
                println("${intContent.content},${stringContent.content}")
                displaySomething(123)
                displaySomething("hello Generic method")
                displaySomething(56.89)
            }) {
                Text(text = "Reset to zero")
            }
        }
    }
}

fun <T>displaySomething(content: T){
    println(content)
}
// Model CLASS
data class Counter(val count: Int)
data class User(val username: String, val password: String)

// ViewModel CLASS
class CounterViewModel : ViewModel() {
    private val _counter = mutableStateOf(Counter(0))
    val counter: State<Counter> = _counter

    fun incrementCounter() {
        _counter.value = Counter(_counter.value.count + 1)
    }

    fun decrementCounter() {
        _counter.value = Counter(_counter.value.count - 1)
    }

    fun resetCounter() {
        _counter.value = Counter(0)
    }
}

class GenericClass<T>(var content: T)