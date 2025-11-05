package com.ayan.boxboxassignmnet.data.repository

import com.ayan.boxboxassignmnet.data.mapper.toDomain
import com.ayan.boxboxassignmnet.data.network.BoxBoxApiService
import com.ayan.boxboxassignmnet.domain.model.RaceScheduleModel
import com.ayan.boxboxassignmnet.domain.model.RaceSessionModel
import com.ayan.boxboxassignmnet.domain.repository.RaceRepository
import com.ayan.boxboxassignmnet.utils.safeApiCall
import javax.inject.Inject

class RaceRepositoryImpl @Inject constructor(
    private val apiService: BoxBoxApiService
): RaceRepository{

    override suspend fun fetchRaceSchedule(): Result<List<RaceScheduleModel>> {
        return safeApiCall(
            apiCall = { apiService.fetchRaceDetails() },
            mapSuccess = {result-> result.toDomain()}
        )
    }

    override suspend fun fetchRaceSession(): Result<List<RaceSessionModel>> {
        TODO("Not yet implemented")
    }

}