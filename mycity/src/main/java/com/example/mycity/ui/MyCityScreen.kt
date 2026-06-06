package com.example.mycity.ui

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mycity.R
import com.example.mycity.data.DataSource
import com.example.mycity.model.Attraction
import com.example.mycity.model.ScreenRoute
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityTopBar(
    title: String,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (canNavigateBack) {
        BackHandler(true, navigateUp)
    }

    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
            )
        },
        colors = TopAppBarColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            scrolledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            navigationIconContentColor = MaterialTheme.colorScheme.onSecondaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onSecondaryContainer,
            actionIconContentColor = MaterialTheme.colorScheme.onSecondaryContainer,
            subtitleContentColor = MaterialTheme.colorScheme.onSecondaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun MyCityApp() {
    val currentActivity = LocalActivity.current as Activity
    val windowSize = calculateWindowSizeClass(currentActivity).widthSizeClass

    val viewModel: MyCityViewModel = viewModel(
        factory = MyCityViewModel.Factory(
            appName = stringResource(R.string.app_name),
            screenRoute = ScreenRoute.CategoryList,
            windowSize = windowSize
        )
    )

    // 监听 windowWidth 变化
    LaunchedEffect(Unit) {
        snapshotFlow { windowSize }
            .collectLatest { newSize ->
                viewModel.updateWindowSize(newSize)
            }
    }

    val uiState by viewModel.uiState.collectAsState()
    val category = uiState.category
    val attraction = uiState.attraction

    val navController = rememberNavController()

    Scaffold(
        topBar = {
            MyCityTopBar(
                title = uiState.title,
                canNavigateBack = uiState.screenRoute.canNavigateBack,
                navigateUp = {
                    if (attraction != null) {
                        viewModel.updateAttraction(null)
                    } else if (category != null) {
                        viewModel.updateCategory(null)
                    }
                    navController.navigateUp()
                }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = uiState.screenRoute.name,
            contentAlignment = Alignment.Center,
            modifier = Modifier.padding(innerPadding).fillMaxSize()
        ) {
            composable(ScreenRoute.CategoryList.name) {
                CategoryListScreen(onClick = {
                    viewModel.updateCategory(it)
                })
            }

            composable(ScreenRoute.AttractionList.name) {
                AttractionListScreen(
                    category!!,
                    onClick = { viewModel.updateAttraction(it) }
                )
            }

            composable(ScreenRoute.Attraction.name) {
                AttractionScreen(attraction!!)
            }

            composable(ScreenRoute.CategoryListAndAttractionList.name) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    CategoryListScreen(
                        onClick = { viewModel.updateCategory(it) },
                        modifier = Modifier.weight(2f)
                    )
                    AttractionListScreen(
                        category!!,
                        onClick = { viewModel.updateAttraction(it) },
                        modifier = Modifier.weight(3f)
                    )
                }
            }

            composable(ScreenRoute.AttractionListAndAttraction.name) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    AttractionListScreen(
                        category!!,
                        onClick = { viewModel.updateAttraction(it) },
                        modifier = Modifier.weight(2f)
                    )
                    AttractionScreen(
                        attraction!!,
                        modifier = Modifier.weight(3f)
                    )
                }
            }
        }
    }
}

@Composable
internal fun ListScreen(
    list: List<String>,
    onClick: (key: String) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(list) {
            Card(
                onClick = { onClick(it) },
                shape = RoundedCornerShape(4.dp),
                colors = CardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    disabledContainerColor = CardDefaults.cardColors().disabledContainerColor,
                    disabledContentColor = CardDefaults.cardColors().disabledContentColor,
                ),
                modifier = Modifier.padding(8.dp).fillMaxWidth()
            ) {
                Text(
                    text = it,
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Composable
fun CategoryListScreen(
    onClick: (key: String) -> Unit,
    modifier: Modifier = Modifier
) {
    ListScreen(
        list = DataSource.all.keys.toList(),
        onClick = onClick,
        modifier = modifier
    )
}

@Composable
fun AttractionListScreen(
    category: String,
    onClick: (attractionName: String) -> Unit,
    modifier: Modifier = Modifier
) {
    val attractionList = DataSource.all[category] ?: emptyList()
    ListScreen(
        list = attractionList.map { it.name },
        onClick = onClick,
        modifier = modifier
    )
}

@Composable
fun AttractionScreen(
    attraction: Attraction,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            elevation = CardDefaults.cardElevation(8.dp),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth().weight(1f, true),
        ) {
            Image(
                painter = painterResource(attraction.imageResId),
                contentDescription = attraction.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        Text(
            text = attraction.description,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(16.dp).fillMaxWidth()
        )
    }
}