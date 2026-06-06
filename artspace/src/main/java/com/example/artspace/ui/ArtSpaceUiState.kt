package com.example.artspace.ui

import com.example.artspace.model.Artwork

data class ArtSpaceUiState(
    val artworkList: List<Artwork> = emptyList(),
    val currentArtworkId: Int = 0,
)