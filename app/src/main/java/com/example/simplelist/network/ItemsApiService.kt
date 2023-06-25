package com.example.simplelist.network

import com.example.simplelist.model.Item
import com.example.simplelist.network.dto.CreateNewItemDto
import com.example.simplelist.network.dto.UpdateItemDto
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ItemsApiService {
    @GET("items")
    suspend fun getItems(): List<Item>

    @POST("item")
    suspend fun createItem(@Body createNewItemDto: CreateNewItemDto): Item

    @PUT("item")
    suspend fun updateItem(@Body updateItemDto: UpdateItemDto): Item

    @DELETE("item/{itemId}")
    suspend fun deleteItem(@Path("itemId") itemId: Int)
}