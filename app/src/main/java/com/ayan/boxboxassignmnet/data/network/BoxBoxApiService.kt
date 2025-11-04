package com.ayan.boxboxassignmnet.data.network

import com.ayan.boxboxassignmnet.data.dto.DriverDto
import com.ayan.boxboxassignmnet.data.dto.RaceDetailsDto
import com.ayan.boxboxassignmnet.utils.AppConstants
import retrofit2.Response
import retrofit2.http.GET

interface BoxBoxApiService {

    @GET(AppConstants.DRIVER_LIST)
    suspend fun fetchDrivers(): Response<DriverDto>

    @GET(AppConstants.RACE_DETAILS)
    suspend fun fetchRaceDetails(): Response<RaceDetailsDto>

}