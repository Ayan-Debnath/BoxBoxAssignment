package com.ayan.boxboxassignmnet.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ayan.boxboxassignmnet.domain.usecase.FetchDriverUseCase
import com.ayan.boxboxassignmnet.ui.mapper.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchDriverUseCase: FetchDriverUseCase
): ViewModel(){

    private val _driverInfo: MutableStateFlow<DriverUiModel> = MutableStateFlow(DriverUiModel())
    val driverInfo: StateFlow<DriverUiModel> = _driverInfo.asStateFlow()

    private fun fetchDriverPositionOne(){
        viewModelScope.launch {
            fetchDriverUseCase()
                .onSuccess {
                    _driverInfo.emit(it.toUiModel())
                }
                .onFailure {  }
        }
    }

    init {
        fetchDriverPositionOne()
    }

}