package com.example.simplelist.data

import com.example.simplelist.model.Item
import com.example.simplelist.network.ItemsApiService

interface ItemsRepository {
    suspend fun getItems(): List<Item>
}

class NetworkItemsRepository(private val itemsApiService: ItemsApiService): ItemsRepository {
    override suspend fun getItems(): List<Item> = itemsApiService.getItems()
}