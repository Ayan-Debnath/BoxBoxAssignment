package com.ayan.boxboxassignmnet.ui.screens.home

data class HomeUiState(
    val isLoading: Boolean = false,
    val driverData: DriverUiModel? = null,
    val sessionUiData: SessionUiModel? = null,
)