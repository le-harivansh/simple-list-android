package com.example.simplelist.ui.screens

sealed class Route(val routeName: String) {
    object Home : Route("home")
    object CreateItem : Route("create-item")
    object UpdateItem : Route("update-item/{itemId}")
}
