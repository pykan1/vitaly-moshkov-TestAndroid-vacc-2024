package com.example.foodapp

import androidx.compose.ui.window.ComposeUIViewController
import com.example.foodapp.root.RootApp
import platform.UIKit.UIViewController


fun MainViewController(): UIViewController {
    return ComposeUIViewController {
        RootApp()
    }
}