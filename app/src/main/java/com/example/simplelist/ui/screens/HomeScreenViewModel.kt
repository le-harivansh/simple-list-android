package com.example.simplelist.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.simplelist.model.Item

sealed interface HomeScreenUiState {
    data class Success(val items: List<Item>): HomeScreenUiState
    object Loading: HomeScreenUiState
    object Error: HomeScreenUiState
}

class HomeScreenViewModel() : ViewModel() {
    var uiState: HomeScreenUiState by mutableStateOf(HomeScreenUiState.Loading)
        private set

    init {
        getItems()
    }

    fun getItems() {
        //
    }
}