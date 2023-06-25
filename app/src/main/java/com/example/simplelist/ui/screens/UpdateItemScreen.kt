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
fun UpdateItemScreen(
    itemId: Int,
    uiState: HomeScreenUiState,
    onUpdate: (Int, String) -> Unit
) {
    when (uiState) {
        is HomeScreenUiState.Success -> {
            val itemToUpdate = uiState.items.first { item -> item.id == itemId }

            var updatedItemTitle by remember { mutableStateOf(itemToUpdate.title) }

            Column {
                TextField(
                    value = updatedItemTitle,
                    onValueChange = { updatedItemTitle = it },
                    modifier = Modifier.fillMaxWidth()
                )

                Button(onClick = { onUpdate(itemToUpdate.id, updatedItemTitle) }) {
                    Text(text = "Update")
                }
            }
        }

        is HomeScreenUiState.Loading -> LoadingScreen()
        is HomeScreenUiState.Error -> ErrorScreen(uiState.errorMessage)
    }
}