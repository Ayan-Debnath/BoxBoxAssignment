package com.ayan.boxboxassignmnet.domain.repository

import com.ayan.boxboxassignmnet.domain.model.RaceScheduleModel
import com.ayan.boxboxassignmnet.domain.model.RaceSessionModel


interface RaceRepository {

    suspend fun fetchRaceSchedule(): Result<List<RaceScheduleModel>>

    suspend fun fetchRaceSession(): Result<List<RaceSessionModel>>

}