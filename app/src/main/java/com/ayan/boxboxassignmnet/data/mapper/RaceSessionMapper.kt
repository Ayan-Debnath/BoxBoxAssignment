package com.ayan.boxboxassignmnet.data.mapper

import com.ayan.boxboxassignmnet.data.dto.RaceDetailsDto
import com.ayan.boxboxassignmnet.domain.model.RaceSessionModel

fun RaceDetailsDto.toRaceSessionModel(): List<RaceSessionModel> {
    return schedule.flatMap { schedule ->
        schedule.sessions.map { session ->
            RaceSessionModel(
                sessionName = session.sessionName,
                startTime = session.startTime,
                endTime = session.endTime
            )
        }
    }
}