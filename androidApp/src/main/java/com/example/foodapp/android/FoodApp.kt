package com.example.foodapp.android

import android.app.Application
import com.example.foodapp.root.di.KoinInjector
import org.koin.android.ext.koin.androidContext

class FoodApp: Application() {

    override fun onCreate() {
        super.onCreate()
        KoinInjector.koinApp.androidContext(this)
    }

}