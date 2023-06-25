package com.example.simplelist.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.simplelist.SimpleListApplication
import com.example.simplelist.data.ItemsRepository
import com.example.simplelist.model.Item
import com.example.simplelist.network.dto.CreateNewItemDto
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface HomeScreenUiState {
    data class Success(val items: List<Item>): HomeScreenUiState
    object Loading: HomeScreenUiState
    data class Error(val errorMessage: String): HomeScreenUiState
}

class HomeScreenViewModel(
    private val itemsRepository: ItemsRepository
) : ViewModel() {
    var uiState: HomeScreenUiState by mutableStateOf(HomeScreenUiState.Loading)
        private set

    init {
        getItems()
    }

    fun getItems() {
        viewModelScope.launch {
            uiState = HomeScreenUiState.Loading
            uiState = try {
                val items = itemsRepository.getItems()

                HomeScreenUiState.Success(items)
            } catch (e: IOException) {
                HomeScreenUiState.Error(e.message ?: "An IOError occurred")
            } catch (e: HttpException) {
                HomeScreenUiState.Error(e.message ?: "A HttpException occurred")
            }
        }
    }

    fun createNewItem(newItemTitle: String) {
        viewModelScope.launch {
            itemsRepository.createNewItem(CreateNewItemDto(newItemTitle))

            getItems()
        }
    }

    fun deleteItem(itemId: Int) {
        viewModelScope.launch {
            itemsRepository.deleteItem(itemId)

            getItems()
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as SimpleListApplication)
                val itemsRepository = application.container.itemsRepository

                HomeScreenViewModel(itemsRepository = itemsRepository)
            }
        }
    }
}