package com.example.simplelist.network

import com.example.simplelist.model.Item
import com.example.simplelist.network.dto.CreateNewItemDto
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ItemsApiService {
    @GET("items")
    suspend fun getItems(): List<Item>

    @POST("item")
    suspend fun createItem(@Body createNewItemDto: CreateNewItemDto): Item

    @DELETE("item/{itemId}")
    suspend fun deleteItem(@Path("itemId") itemId: Int)
}