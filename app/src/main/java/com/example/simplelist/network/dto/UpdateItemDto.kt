package com.example.simplelist.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UpdateItemDto(
    @SerialName("id")
    val id: Int,

    @SerialName("title")
    val title: String
)