package com.example.simplelist.data

import com.example.simplelist.model.Item
import com.example.simplelist.network.ItemsApiService

interface ItemsRepository {
    suspend fun getItems(): List<Item>

    suspend fun deleteItem(itemId: Int)
}

class NetworkItemsRepository(private val itemsApiService: ItemsApiService): ItemsRepository {
    override suspend fun getItems(): List<Item> = itemsApiService.getItems()

    override suspend fun deleteItem(itemId: Int) = itemsApiService.deleteItem(itemId)
}