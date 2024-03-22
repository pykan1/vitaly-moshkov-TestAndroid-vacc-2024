package com.example.foodapp

import androidx.compose.ui.window.ComposeUIViewController
import com.example.foodapp.di.KoinInjector
import com.example.foodapp.platform.DriverFactory
import com.example.foodapp.platform.createDatabase
import com.example.foodapp.screens.root.RootApp
import org.koin.dsl.module
import platform.UIKit.UIViewController


val platformModule = module {
    single { createDatabase(DriverFactory()) }
}

fun MainViewController(): UIViewController {
    KoinInjector.loadModules(listOf(platformModule))
    return ComposeUIViewController {
        RootApp()
    }
}