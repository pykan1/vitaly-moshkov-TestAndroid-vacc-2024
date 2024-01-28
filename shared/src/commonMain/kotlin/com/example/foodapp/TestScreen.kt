package com.example.foodapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.core.screen.Screen

class TestScreen: Screen {

    @Composable
    override fun Content() {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize().background(Color.White)) {
            Text(text = "hello world")
        }
    }
}