package com.ayan.boxboxassignmnet.data.mapper

import com.ayan.boxboxassignmnet.data.dto.DriverDto
import com.ayan.boxboxassignmnet.domain.model.DriverModel


fun DriverDto.toDomainModel(): List<DriverModel> {
    return drivers.map {
        DriverModel(
            driverName = it.firstName,
            points = it.points,
            wins = it.wins,
            position = it.position
        )
    }
}