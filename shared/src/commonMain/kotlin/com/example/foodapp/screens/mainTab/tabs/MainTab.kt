package com.example.foodapp.root.screens.mainTab.tabs

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.foodapp.images.FoodResourceImages
import com.example.foodapp.screens.main.MainScreen
import com.example.foodapp.strings.FoodResourceStrings
import io.github.skeptick.libres.compose.painterResource

object MainTab: Tab {

    @Composable
    override fun Content() {
        Navigator(MainScreen())
    }

    override val options: TabOptions
        @Composable
        get() = TabOptions(
            index = 1.toUShort(),
            title = FoodResourceStrings.main,
            icon = FoodResourceImages.food.painterResource(),
        )
}