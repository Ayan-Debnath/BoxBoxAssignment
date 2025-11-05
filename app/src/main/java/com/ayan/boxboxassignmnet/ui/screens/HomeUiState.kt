package com.ayan.boxboxassignmnet.ui.screens

data class HomeUiState(
    val isLoading: Boolean = false,
    val driverData: DriverUiModel? = null,
    val sessionUiData: SessionUiModel? = null,
)