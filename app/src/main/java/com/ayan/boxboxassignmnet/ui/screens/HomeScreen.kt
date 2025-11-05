package com.ayan.boxboxassignmnet.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {

    val driverUiState = viewModel.driverInfo.collectAsStateWithLifecycle().value

    Column {
        Text(
            text = driverUiState.driverName
        )
        Text(
            text = "${driverUiState.wins}"
        )
        Text(
            text = "${driverUiState.position}"
        )
    }

}