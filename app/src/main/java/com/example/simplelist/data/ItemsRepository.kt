package com.example.simplelist.data

import com.example.simplelist.model.Item
import com.example.simplelist.network.ItemsApiService
import com.example.simplelist.network.dto.CreateNewItemDto
import com.example.simplelist.network.dto.UpdateItemDto

interface ItemsRepository {
    suspend fun getItems(): List<Item>

    suspend fun createNewItem(newItemTitle: String): Item

    suspend fun updateItem(id: Int, updatedTitle: String): Item

    suspend fun deleteItem(itemId: Int)
}

class NetworkItemsRepository(private val itemsApiService: ItemsApiService): ItemsRepository {
    override suspend fun getItems(): List<Item> = itemsApiService.getItems()

    override suspend fun createNewItem(newItemTitle: String): Item = itemsApiService.createItem(
        CreateNewItemDto(newItemTitle)
    )

    override suspend fun updateItem(id: Int, updatedTitle: String): Item = itemsApiService.updateItem(
        UpdateItemDto(id, updatedTitle)
    )

    override suspend fun deleteItem(itemId: Int) = itemsApiService.deleteItem(itemId)
}