package com.example.foodapp.root.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.foodapp.root.screens.FoodImage
import com.example.foodapp.root.screens.foodByCategory.FoodByCategoryScreen

internal class MainScreen : Screen {

    @Composable
    override fun Content() {
        val viewModel = rememberScreenModel { MainViewModel() }
        val state by viewModel.stateFlow.collectAsState()
        val navigator = LocalNavigator.currentOrThrow
        LaunchedEffect(viewModel) {
            viewModel.getAllCategories()
        }
        LazyColumn(
            contentPadding = PaddingValues(vertical = 20.dp),
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            items(state.categories) {
                Card(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp).clickable {
                        navigator.push(FoodByCategoryScreen(it.strCategory))
                    },
                    shape = RoundedCornerShape(12.dp)
                ) {

                    Row(
                        modifier = Modifier.fillMaxWidth().padding(7.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        FoodImage(
                            url = it.strCategoryThumb, modifier = Modifier.size(64.dp).clip(
                                CircleShape
                            ), contentScale = ContentScale.Crop
                        )

                        Column(modifier = Modifier.weight(1f).padding(start = 8.dp)) {
                            Text(
                                text = it.strCategory,
                                fontWeight = FontWeight.W700,
                                fontSize = 16.sp,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )

                            Text(
                                text = it.strCategoryDescription,
                                fontWeight = FontWeight.W500,
                                fontSize = 14.sp,
                                maxLines = 4,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.padding(top = 5.dp)
                            )
                        }
                    }

                }
            }
        }
    }
}