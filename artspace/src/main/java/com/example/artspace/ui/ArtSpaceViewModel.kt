package com.example.artspace.ui

import androidx.lifecycle.ViewModel
import com.example.artspace.data.LocalArtworksDataProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class ArtSpaceViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        ArtSpaceUiState(
            artworkList = LocalArtworksDataProvider.getArtworksData(),
            currentArtworkId = 0
        )
    )
    val uiState: StateFlow<ArtSpaceUiState> = _uiState

    fun incrementCurrentArtwork() {
        _uiState.update {
            it.copy(currentArtworkId = (it.currentArtworkId + 1) % it.artworkList.size)
        }
    }

    fun decrementCurrentArtwork() {
        _uiState.update {
            it.copy(
                currentArtworkId = (it.currentArtworkId - 1 + it.artworkList.size) % it.artworkList.size
            )
        }
    }
}
