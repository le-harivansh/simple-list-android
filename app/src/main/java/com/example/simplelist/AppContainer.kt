package com.example.simplelist

import com.example.simplelist.data.ItemsRepository
import com.example.simplelist.data.NetworkItemsRepository
import com.example.simplelist.network.ItemsApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val itemsRepository: ItemsRepository
}

/**
 * To access `localhost` on the development machine (i.e.: the machine hosting the android
 * emulator), we should use the ip: `10.0.2.2`.
 *
 * `10.0.2.2` is a special alias pointing to the host loopback interface - i.e. 127.0.0.1 / localhost
 *
 * See: https://developer.android.com/studio/run/emulator-networking#networkaddresses
 */
private const val LOCALHOST = "10.0.2.2"

class DefaultAppContainer: AppContainer {
    private val baseUrl = "http://$LOCALHOST:3000"

    @OptIn(ExperimentalSerializationApi::class)
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    override val itemsRepository: ItemsRepository by lazy {
        val itemsApiService = retrofit.create(ItemsApiService::class.java)

        NetworkItemsRepository(itemsApiService)
    }
}