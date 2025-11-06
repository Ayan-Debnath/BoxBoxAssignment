package com.ayan.boxboxassignmnet.ui.screens.details

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ayan.boxboxassignmnet.domain.usecase.ShowUpComingRaceUseCase
import com.ayan.boxboxassignmnet.ui.mapper.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val showUpComingRaceUseCase: ShowUpComingRaceUseCase
): ViewModel(){


    private val _uiState: MutableStateFlow<RaceDetailsUiState> = MutableStateFlow(RaceDetailsUiState())
    val uiState: StateFlow<RaceDetailsUiState> = _uiState.asStateFlow()

    private fun loadRaceDetails(){
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            showUpComingRaceUseCase()
                .onSuccess {raceDetails->
                    val data = raceDetails.toUiModel()
                    _uiState.update { it.copy(isLoading = false, raceDetailsUiModel = data)}
                }
        }
    }

    init {
        loadRaceDetails()
    }


}