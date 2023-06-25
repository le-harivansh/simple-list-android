package com.example.simplelist.network

import com.example.simplelist.model.Item
import retrofit2.http.GET

interface ItemsApiService {
    @GET("items")
    suspend fun getItems(): List<Item>
}