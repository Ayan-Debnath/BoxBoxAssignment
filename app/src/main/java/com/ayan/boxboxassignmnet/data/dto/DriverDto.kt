package com.ayan.boxboxassignmnet.data.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DriverDto(
    val drivers: List<Driver>
)

@JsonClass(generateAdapter = true)
data class Driver(
    val driverCode: String,
    val driverId: String,
    val firstName: String,
    val lastName: String,
    val podiums: Int,
    val points: Int,
    val poles: Int,
    val position: Int,
    val racingNumber: Int,
    val teamId: String,
    val teamName: String,
    val wins: Int
)