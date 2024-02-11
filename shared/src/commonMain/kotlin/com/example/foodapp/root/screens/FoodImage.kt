package com.example.foodapp.root.screens

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.layout.ContentScale
import com.seiko.imageloader.LocalImageLoader
import com.seiko.imageloader.rememberImagePainter

@Composable
fun FoodImage(
    url: String,
    contentDescription: String? = null,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
    modifier: Modifier = Modifier,
) {

    if (url.startsWith("http")) {
        Image(
            painter = rememberImagePainter(url),
            contentDescription = contentDescription,
            modifier = modifier,
            contentScale = contentScale,
            alpha = alpha,
            alignment = alignment,
            colorFilter = colorFilter
        )
    } else {
        Image(
            painter = rememberImagePainter(url),
            contentDescription = contentDescription,
            modifier = modifier,
            contentScale = contentScale,
            alpha = alpha,
            alignment = alignment,
            colorFilter = colorFilter
        )
    }

}