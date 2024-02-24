package com.example.foodapp.root.screens.mainTab

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.example.foodapp.root.screens.mainTab.tabs.BucketTab
import com.example.foodapp.root.screens.mainTab.tabs.MainTab
import com.example.foodapp.root.screens.mainTab.tabs.ProfileTab

class MainTabScreen(private val tab: Tab = MainTab) : Screen {

    @Composable
    override fun Content() { val tabs = listOf(MainTab, ProfileTab, BucketTab)
        TabNavigator(
            tab = tab
        ) {
            val tabNavigator = LocalTabNavigator.current
            Column(modifier = Modifier.fillMaxSize().background(Color.White)) {
                Box(modifier = Modifier.weight(1f)) {
                    it.current.Content()
                }
                Row(
                    modifier = Modifier.fillMaxWidth().border(width = 1.dp, color = Color.Black),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    tabs.forEach {
                        Column(
                            modifier = Modifier.padding(vertical = 5.dp).size(45.dp).clickable {
                                tabNavigator.current = it
                            },
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = it.options.icon!!,
                                contentDescription = null,
                                modifier = Modifier.size(24.dp),
                                colorFilter = ColorFilter.tint(color = if (it == tabNavigator.current) Color.Black else Color.LightGray)
                            )
                            Text(
                                text = it.options.title,
                                fontSize = 12.sp,
                                fontWeight = FontWeight(600),
                                modifier = Modifier.padding(top = 4.dp),
                                color = if (it == tabNavigator.current) Color.Black else Color.LightGray
                            )
                        }

                    }

                }
            }
        }
    }

}