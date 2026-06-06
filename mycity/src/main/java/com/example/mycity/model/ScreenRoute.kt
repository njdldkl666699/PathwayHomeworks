package com.example.mycity.model

enum class ScreenRoute(val canNavigateBack: Boolean) {
    CategoryList(false),
    AttractionList(true),
    Attraction(true),
    CategoryListAndAttractionList(false),
    AttractionListAndAttraction(false),
}