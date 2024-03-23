package com.example.foodapp.screens.foodByCategory

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material3.Card
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.HPlusMobiledata
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.foodapp.domain.models.FoodUI
import com.example.foodapp.screens.FoodImage
import com.example.foodapp.screens.foodDetail.FoodDetailScreen

internal class FoodByCategoryScreen(private val category: String) : Screen {

    @Composable
    override fun Content() {
        val viewModel = rememberScreenModel { FoodByCategoryViewModel() }
        val state by viewModel.stateFlow.collectAsState()
        val navigator = LocalNavigator.currentOrThrow

        LaunchedEffect(viewModel) {
            viewModel.loadFoods(category)
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
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
                        text = category,
                        fontWeight = FontWeight.W700,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                }
            }

            items(state.foods) {
                FoodItem(navigator, it.idMeal, it.strMeal, it.strMealThumb) {
                    IconButton(
                        modifier = Modifier.size(24.dp),
                        onClick = {
                            viewModel.insertInBucket(it)
                        },
                    ) {
                        Icon(contentDescription = null, imageVector = Icons.Default.Add)
                    }

                }
            }
        }

    }
}

@Composable
internal fun FoodItem(
    navigator: Navigator,
    idMeal: String,
    strMeal: String,
    strMealThumb: String,
    icon: @Composable (() -> Unit)
) {
    Card(
        modifier = Modifier.fillMaxWidth().clickable {
            navigator.push(FoodDetailScreen(idMeal))
        },
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth().padding(7.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            FoodImage(
                modifier = Modifier.size(45.dp).clip(CircleShape),
                url = strMealThumb,
                contentScale = ContentScale.Crop
            )

            Text(
                text = strMeal,
                fontSize = 16.sp,
                fontWeight = FontWeight.W600,
                modifier = Modifier.weight(1f).padding(start = 12.dp, end = 15.dp)
            )

            icon()
        }

    }
}