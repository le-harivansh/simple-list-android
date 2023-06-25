package com.example.simplelist

import android.app.Application

class SimpleListApplication: Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()

        container = DefaultAppContainer()
    }
}