package com.example.mycity.ui

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mycity.data.DataSource
import com.example.mycity.model.CityUiState
import com.example.mycity.model.ScreenRoute
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MyCityViewModel(
    private val appName: String,
    screenRoute: ScreenRoute,
    windowSize: WindowWidthSizeClass
) : ViewModel() {

    class Factory(
        private val appName: String,
        private val screenRoute: ScreenRoute,
        private val windowSize: WindowWidthSizeClass
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MyCityViewModel(appName, screenRoute, windowSize) as T
        }
    }

    private val _uiState = MutableStateFlow(
        CityUiState(
            title = appName,
            screenRoute = screenRoute,
            windowSize = windowSize
        )
    )
    val uiState = _uiState.asStateFlow()

    fun updateCategory(category: String?) {
        updateUiState(category, null, uiState.value.windowSize)
    }

    fun updateAttraction(attractionName: String?) {
        updateUiState(uiState.value.category, attractionName, uiState.value.windowSize)
    }

    fun updateWindowSize(windowSize: WindowWidthSizeClass) {
        updateUiState(uiState.value.category, uiState.value.attraction?.name, windowSize)
    }

    internal fun updateUiState(category: String?, attractionName: String?, windowSize: WindowWidthSizeClass) {
        _uiState.update {
            val expanded = windowSize == WindowWidthSizeClass.Expanded

            val newAttractionName = if (
                it.windowSize == WindowWidthSizeClass.Expanded &&
                expanded && attractionName == it.attraction?.name
            ) null else attractionName

            val newTitle = if (expanded) appName else newAttractionName ?: category ?: appName

            val newRoute = if (expanded)
                if (category == null) ScreenRoute.CategoryList
                else if (newAttractionName == null) ScreenRoute.CategoryListAndAttractionList
                else ScreenRoute.AttractionListAndAttraction
            else
                if (category == null) ScreenRoute.CategoryList
                else if (newAttractionName == null) ScreenRoute.AttractionList
                else ScreenRoute.Attraction

            val attraction = DataSource.all[category]?.find { a -> a.name == newAttractionName }

            it.copy(
                category = category,
                attraction = attraction,
                title = newTitle,
                screenRoute = newRoute,
                windowSize = windowSize
            )
        }
    }
}
