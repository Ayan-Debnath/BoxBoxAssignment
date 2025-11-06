package com.ayan.boxboxassignmnet.domain.model

class RaceScheduleModel(
    val raceName: String,
    val round: Int,
    val circuitId: String,
    val startTime: Long,
    val endTime: Long
)

fun RaceScheduleModel.isUpComing(): Boolean{
    val now = System.currentTimeMillis() / 1000
    return now < startTime
}