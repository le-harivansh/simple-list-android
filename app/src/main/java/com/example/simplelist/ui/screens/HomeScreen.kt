package com.example.simplelist.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.simplelist.model.Item

@Composable
fun HomeScreen(uiState: HomeScreenUiState, modifier: Modifier = Modifier) {
    when (uiState) {
        is HomeScreenUiState.Loading -> LoadingScreen(modifier = modifier)
        is HomeScreenUiState.Error -> ErrorScreen(modifier = modifier)
        is HomeScreenUiState.Success -> ItemsScreen(items = uiState.items, modifier = modifier)
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Text(text = "LOADING...")
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Text(text = "ERROR")
}

@Composable
fun ItemsScreen(items: List<Item>, modifier: Modifier = Modifier) {
    Text(text = "GOT ${items.size} ITEMS")
}