package com.example.simplelist.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.simplelist.model.Item
import com.example.simplelist.ui.composables.ListItem

@Composable
fun HomeScreen(uiState: HomeScreenUiState, modifier: Modifier = Modifier) {
    when (uiState) {
        is HomeScreenUiState.Loading -> LoadingScreen(modifier = modifier)
        is HomeScreenUiState.Error -> ErrorScreen(uiState.errorMessage, modifier = modifier)
        is HomeScreenUiState.Success -> ItemsScreen(listItems = uiState.items)
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Text(text = "LOADING...", modifier = modifier)
}

@Composable
fun ErrorScreen(message: String, modifier: Modifier = Modifier) {
    Text(text = "ERROR: $message", modifier = modifier)
}

@Composable
fun ItemsScreen(listItems: List<Item>) {
    LazyColumn {
        items(listItems) { ListItem(item = it) }
    }
}
