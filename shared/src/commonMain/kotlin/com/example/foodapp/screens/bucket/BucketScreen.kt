package com.example.foodapp.screens.bucket

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.foodapp.screens.foodByCategory.FoodItem
import com.example.foodapp.strings.FoodResourceStrings

class BucketScreen : Screen {

    @Composable
    override fun Content() {

        val viewModel = rememberScreenModel { BucketViewModel() }
        val state by viewModel.stateFlow.collectAsState()
        val navigator = LocalNavigator.currentOrThrow

        LaunchedEffect(viewModel) {
            viewModel.loadBucket()
        }
        Box(modifier = Modifier.fillMaxSize().background(Color.White)) {
            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
                contentPadding = PaddingValues(
                    top = 30.dp, bottom = 90.dp
                )
            ) {
                items(state.items) {
                    FoodItem(navigator, it.idMeal, it.strMeal, it.image) {
                        IconButton(
                            modifier = Modifier.size(24.dp),
                            onClick = {
                                viewModel.deleteItem(it.id)
                            },
                        ) {
                            Icon(contentDescription = null, imageVector = Icons.Default.Delete)
                        }

                    }
                }
            }

            Button(
                modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter)
                    .padding(start = 16.dp, end = 30.dp, bottom = 40.dp).height(50.dp),
                onClick = {
                    viewModel.order()
                }
            ) {
                Text(
                    text = FoodResourceStrings.order_all,
                    fontWeight = FontWeight.W600,
                    fontSize = 16.sp
                )
            }
        }
    }
}