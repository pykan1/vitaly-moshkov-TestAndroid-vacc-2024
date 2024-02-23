package com.example.foodapp.root.screens.foodDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

internal class FoodDetailScreen(private val id: String) : Screen {

    @Composable
    override fun Content() {
        val viewModel = rememberScreenModel { FoodDetailViewModel() }
        val state by viewModel.stateFlow.collectAsState()
        val navigator = LocalNavigator.currentOrThrow

        LaunchedEffect(viewModel) {
            viewModel.loadFoodById(id = id)
        }

        Column(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(modifier = Modifier.fillMaxWidth().padding(top = 16.dp), verticalAlignment = Alignment.CenterVertically) {
                IconButton(
                    onClick = { navigator.pop() }
                ) {
                    Image(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }

                Text(
                    text = state.foodDetailUI.strMeal,
                    fontWeight = FontWeight.W700,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }


            Text(
                text = state.foodDetailUI.strInstructions,
                fontWeight = FontWeight.W400,
                fontSize = 13.sp,
                lineHeight = 14.sp,
                modifier = Modifier.padding(top = 16.dp)
            )

        }
    }
}