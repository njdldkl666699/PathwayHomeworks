package com.example.artspace.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.artspace.R

@Composable
fun ArtSpaceApp(
) {
    val viewModel: ArtSpaceViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()
    val currentArtwork = uiState.artworkList[uiState.currentArtworkId]

    Scaffold(
        topBar = {
            ArtSpaceAppBar()
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            ImageCard(
                imageResourceId = currentArtwork.imageResourceId,
                contentDescriptionResId = currentArtwork.titleResourceId,
                modifier = Modifier.weight(0.7f)
            )
            ArtInfo(
                titleResourceId = currentArtwork.titleResourceId,
                artistResourceId = currentArtwork.artistResourceId,
                year = currentArtwork.year,
                modifier = Modifier
            )
            NavigationBar(
                onPreviousClick = viewModel::decrementCurrentArtwork,
                onNextClick = viewModel::incrementCurrentArtwork,
                modifier = Modifier,
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArtSpaceAppBar(
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                color = MaterialTheme.colorScheme.onPrimary,
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = modifier,
    )
}

@Composable
fun ImageCard(
    @DrawableRes imageResourceId: Int,
    @StringRes contentDescriptionResId: Int,
    modifier: Modifier = Modifier,
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(imageResourceId),
            contentDescription = stringResource(contentDescriptionResId),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun ArtInfo(
    @StringRes titleResourceId: Int,
    @StringRes artistResourceId: Int,
    year: Int,
    modifier: Modifier = Modifier,
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = stringResource(titleResourceId),
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = stringResource(artistResourceId),
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = year.toString(),
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Composable
fun NavigationBar(
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Button(
            onClick = onPreviousClick,
            modifier = Modifier.weight(0.8f)
        ) {
            Text(text = stringResource(R.string.previous))
        }
        Button(
            onClick = onNextClick,
            modifier = Modifier.weight(0.8f)
        ) {
            Text(text = stringResource(R.string.next))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceAppPreview() {
    ArtSpaceApp()
}