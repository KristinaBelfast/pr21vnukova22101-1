package com.example.pr21vnukova22101.ui.theme

import android.content.ContentValues
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

class UserActivity : ComponentActivity() {
    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dbHelper = DatabaseHelper(this)

        setContent {
            UserForm()
        }
    }
    @Composable
    fun UserForm() {
        val name = remember { mutableStateOf("") }
        val age = remember { mutableStateOf("") }

        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement= Arrangement.Center,
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
                    saveUser(name.value, age.value)
                }) {
                    Text("Сохранить")
                }
            }
        }
    }

    private fun saveUser(name: String, age: String) {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put("name", name)
            put("age", age.toInt())
        }
        db.insert("users", null, values)
        db.close()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewUserForm() {
    UserForm()
}

@Composable
fun UserForm() {
    TODO("Not yet implemented")
}