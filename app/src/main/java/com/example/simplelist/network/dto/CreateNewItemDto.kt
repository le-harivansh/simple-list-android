package com.example.simplelist.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreateNewItemDto(
    @SerialName("title")
    val title: String
)