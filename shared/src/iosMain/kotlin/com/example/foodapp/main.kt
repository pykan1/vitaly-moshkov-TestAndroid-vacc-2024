package com.example.foodapp

import androidx.compose.ui.window.ComposeUIViewController
import com.example.foodapp.root.di.KoinInjector
import com.example.foodapp.root.screens.root.RootApp
import platform.UIKit.UIViewController


fun MainViewController(): UIViewController {

    KoinInjector.koinApp

    return ComposeUIViewController {
        RootApp()
    }
}