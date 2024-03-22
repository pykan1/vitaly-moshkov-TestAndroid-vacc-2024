package com.example.foodapp.root.screens.mainTab.tabs

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.foodapp.images.FoodResourceImages
import com.example.foodapp.screens.profile.ProfileScreen
import com.example.foodapp.strings.FoodResourceStrings
import io.github.skeptick.libres.compose.painterResource

object ProfileTab : Tab {
    @Composable
    override fun Content() {
        Navigator(ProfileScreen())

    }

    override val options: TabOptions
        @Composable
        get() = TabOptions(
            index = 2.toUShort(),
            title = FoodResourceStrings.user,
            icon = FoodResourceImages.user.painterResource(),
        )
}