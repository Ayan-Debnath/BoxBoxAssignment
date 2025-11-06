package com.ayan.boxboxassignmnet.ui.screens.details

data class RaceDetailsUiState(
    val isLoading: Boolean = false,
    val raceDetailsUiModel: RaceDetailsUiModel? = null,
    val errorMessage: String=""
)
