package com.ayan.boxboxassignmnet.data.repository

import com.ayan.boxboxassignmnet.data.mapper.toDomainModel
import com.ayan.boxboxassignmnet.data.network.BoxBoxApiService
import com.ayan.boxboxassignmnet.domain.model.DriverModel
import com.ayan.boxboxassignmnet.domain.repository.DriverRepository
import com.ayan.boxboxassignmnet.utils.safeApiCall
import javax.inject.Inject

class DriverRepositoryImpl @Inject constructor(
    private val apiService: BoxBoxApiService
) : DriverRepository {

    override suspend fun fetchDrivers(): Result<List<DriverModel>> {
        return safeApiCall(
            apiCall = { apiService.fetchDrivers() },
            mapSuccess = { response -> response.toDomainModel() }
        )
    }

}