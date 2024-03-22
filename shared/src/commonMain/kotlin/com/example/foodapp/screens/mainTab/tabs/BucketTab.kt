package com.example.foodapp.root.screens.mainTab.tabs

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.foodapp.images.FoodResourceImages
import com.example.foodapp.screens.bucket.BucketScreen
import com.example.foodapp.strings.FoodResourceStrings
import io.github.skeptick.libres.compose.painterResource

object BucketTab: Tab {

    @Composable
    override fun Content() {
        Navigator(BucketScreen())
    }

    override val options: TabOptions
        @Composable
        get() = TabOptions(
            index = 3.toUShort(),
            title = FoodResourceStrings.backet,
            icon = FoodResourceImages.shopping.painterResource(),
        )
}