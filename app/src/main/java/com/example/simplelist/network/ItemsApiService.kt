package com.example.simplelist.network

import com.example.simplelist.model.Item
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface ItemsApiService {
    @GET("items")
    suspend fun getItems(): List<Item>

    @DELETE("item/{itemId}")
    suspend fun deleteItem(@Path("itemId") itemId: Int): Unit
}