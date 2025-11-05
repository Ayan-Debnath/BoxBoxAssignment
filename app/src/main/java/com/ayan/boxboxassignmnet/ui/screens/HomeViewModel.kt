package com.ayan.boxboxassignmnet.ui.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ayan.boxboxassignmnet.domain.usecase.FetchDriverUseCase
import com.ayan.boxboxassignmnet.domain.usecase.ShowUpComingSessionUseCase
import com.ayan.boxboxassignmnet.ui.mapper.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchDriverUseCase: FetchDriverUseCase,
    private val upComingSessionUseCase: ShowUpComingSessionUseCase
): ViewModel(){

    private val _uiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    private fun loadHomeScreenData(){
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            val driverDeferred= async { fetchDriverUseCase() }
            val sessionDeferred= async { upComingSessionUseCase() }

            val driverResult = driverDeferred.await()
            val sessionResult = sessionDeferred.await()

            _uiState.update {
                it.copy(
                    isLoading = false,
                    driverData = driverResult.getOrNull()?.toUiModel(),
                    sessionUiData = sessionResult.getOrNull()?.toUiModel()
                )
            }
        }
    }

    init {
        loadHomeScreenData()
    }

}