package com.ayan.boxboxassignmnet.data.mapper

import com.ayan.boxboxassignmnet.data.dto.RaceDetailsDto
import com.ayan.boxboxassignmnet.domain.model.RaceScheduleModel

fun RaceDetailsDto.toRaceScheduleModel(): List<RaceScheduleModel> {

    return schedule.map {
        RaceScheduleModel(
            raceName = it.raceName,
            round = it.round,
            circuitId = it.circuitId,
            startTime = it.raceStartTime,
            endTime = it.raceEndTime
        )
    }

}