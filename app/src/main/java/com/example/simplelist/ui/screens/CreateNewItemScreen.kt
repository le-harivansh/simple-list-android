package com.example.simplelist.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateNewItemScreen(onCreate: (String) -> Unit) {
    var newItemTitle by remember { mutableStateOf("") }

    Column {
        TextField(
            value = newItemTitle,
            onValueChange = { newItemTitle = it },
            modifier = Modifier.fillMaxWidth()
        )

        Button(onClick = { onCreate(newItemTitle) }) {
            Text(text = "Create")
        }
    }
}