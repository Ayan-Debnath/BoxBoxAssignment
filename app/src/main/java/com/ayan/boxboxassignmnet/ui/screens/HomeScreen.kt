package com.ayan.boxboxassignmnet.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {

    val uiState = viewModel.uiState.collectAsStateWithLifecycle().value


    Column(
        modifier = Modifier.statusBarsPadding().padding(16.dp)
    ) {
        if (uiState.isLoading){
            Text("Loading", fontSize = 24.sp)
        } else {
            Text(
                text = "${uiState.driverData?.driverName}"
            )
            Text(
                text = "${uiState.driverData?.wins}"
            )
            Text(
                text = "${uiState.driverData?.position}"
            )
            Text(
                text = "${uiState.sessionUiData?.sessionName} ${uiState.sessionUiData?.startTime}"
            )
        }
    }

}