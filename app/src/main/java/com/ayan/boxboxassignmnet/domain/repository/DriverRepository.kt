package com.ayan.boxboxassignmnet.domain.repository

import com.ayan.boxboxassignmnet.domain.model.DriverModel

interface DriverRepository {

    suspend fun fetchDrivers(): Result<List<DriverModel>>

}