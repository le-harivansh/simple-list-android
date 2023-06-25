package com.example.simplelist.data

import com.example.simplelist.model.Item
import com.example.simplelist.network.ItemsApiService
import com.example.simplelist.network.dto.CreateNewItemDto

interface ItemsRepository {
    suspend fun getItems(): List<Item>

    suspend fun createNewItem(newItemTitle: CreateNewItemDto): Item

    suspend fun deleteItem(itemId: Int)
}

class NetworkItemsRepository(private val itemsApiService: ItemsApiService): ItemsRepository {
    override suspend fun getItems(): List<Item> = itemsApiService.getItems()

    override suspend fun createNewItem(newItemTitle: CreateNewItemDto): Item = itemsApiService.createItem(newItemTitle)

    override suspend fun deleteItem(itemId: Int) = itemsApiService.deleteItem(itemId)
}