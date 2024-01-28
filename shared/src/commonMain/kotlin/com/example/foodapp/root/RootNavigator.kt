package com.example.foodapp.root

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import cafe.adriel.voyager.navigator.Navigator

val RootNavigator: ProvidableCompositionLocal<Navigator?> = staticCompositionLocalOf {
    null
}