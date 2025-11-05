package com.ayan.boxboxassignmnet.utils

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

object HelperFunction {

    fun convertEpochToDateTime(epochSeconds: Long): String {
        val instant = Instant.ofEpochSecond(epochSeconds)

        val localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())

        val formatter = DateTimeFormatter.ofPattern("dd EEEE h:mma", Locale.ENGLISH)
        return localDateTime.format(formatter)
    }

}