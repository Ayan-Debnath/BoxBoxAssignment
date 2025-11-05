package com.ayan.boxboxassignmnet.ui.mapper

import com.ayan.boxboxassignmnet.domain.model.DriverModel
import com.ayan.boxboxassignmnet.ui.screens.home.DriverUiModel

fun DriverModel.toUiModel() = DriverUiModel(
    driverName = driverName,
    points = points,
    wins = wins,
    position = position
)