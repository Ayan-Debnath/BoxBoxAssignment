package com.ayan.boxboxassignmnet.domain.model

data class RaceSessionModel(
    val sessionName: String,
    val startTime: Long,
    val endTime: Long
)

fun RaceSessionModel.isUpComing(): Boolean{
    val now = System.currentTimeMillis() / 1000
    return now < startTime
}