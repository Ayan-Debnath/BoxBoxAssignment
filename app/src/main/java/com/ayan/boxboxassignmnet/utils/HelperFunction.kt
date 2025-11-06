package com.ayan.boxboxassignmnet.utils

import java.time.Duration
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

object HelperFunction {

    fun convertEpochToDateTime(epochSeconds: Long): String {
        val instant = Instant.ofEpochSecond(epochSeconds)

        val localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())

        val formatter = DateTimeFormatter.ofPattern("dd EEEE,h:mm-a", Locale.ENGLISH)
        return localDateTime.format(formatter)
    }

    fun convertEpochToDateRange(startTime: Long, endTime: Long): String {
        val startInstant = Instant.ofEpochSecond(startTime)
        val endInstant = Instant.ofEpochSecond(endTime)

        val startTimeLocal = LocalDateTime.ofInstant(startInstant, ZoneId.systemDefault())
        val endTimeLocal = LocalDateTime.ofInstant(endInstant, ZoneId.systemDefault())

        val startDay = DateTimeFormatter.ofPattern("d", Locale.ENGLISH).format(startTimeLocal)
        val endDay = DateTimeFormatter.ofPattern("d", Locale.ENGLISH).format(endTimeLocal)
        val month = DateTimeFormatter.ofPattern("MMMM", Locale.ENGLISH).format(startTimeLocal)

        return "$startDay-$endDay $month"
    }

    fun getTimeRemaining(startTime: Long): String{
        val now = Instant.now()
        val epochStartTime = Instant.ofEpochSecond(startTime)
        val totalMinutes = Duration.between(now, epochStartTime).toMinutes()
        val days = totalMinutes / (24*60)
        val hours = (totalMinutes % (24 * 60)) / 60
        val minutes = totalMinutes % 60
        return String.format("%02d,%02d,%02d", days, hours, minutes)
    }

}