package com.example.mycity.model

import androidx.annotation.DrawableRes

data class Attraction(
    val name: String,
    val description: String,
    @DrawableRes val imageResId: Int
)
