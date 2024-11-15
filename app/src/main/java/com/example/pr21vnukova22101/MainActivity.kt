package com.example.pr21vnukova22101
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    var name = remember { mutableStateOf("") }
    var age = remember { mutableStateOf("") }

    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = name.value,
                onValueChange = { name.value = it },
                label = { Text("Введите имя") }
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = age.value,
                onValueChange = { age.value = it },
                label = { Text("Введите возраст") }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                // Здесь можно добавить код для передачи данных в SQLite
                // Например, открытие нового экрана UserActivity
            }) {
                Text("Отправить")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp()
}