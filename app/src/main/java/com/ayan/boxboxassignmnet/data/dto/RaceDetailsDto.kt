package com.ayan.boxboxassignmnet.data.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RaceDetailsDto(
    val schedule: List<Schedule>
)

@JsonClass(generateAdapter = true)
data class Schedule(
    val circuitId: String,
    val isSprint: Boolean,
    val podium: List<String>,
    val raceEndTime: Int,
    val raceId: String,
    val raceName: String,
    val raceStartTime: Int,
    val raceState: String,
    val round: Int,
    val sessions: List<Session>
)

@JsonClass(generateAdapter = true)
data class Session(
    val _id: String,
    val endTime: Int,
    val sessionId: String,
    val sessionName: String,
    val sessionState: String,
    val sessionType: String,
    val startTime: Int
)