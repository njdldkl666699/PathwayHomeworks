package com.example.mycity.model

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass

data class CityUiState(
    val category: String? = null,
    val attraction: Attraction? = null,
    val title: String,
    val screenRoute: ScreenRoute,
    val windowSize: WindowWidthSizeClass
)