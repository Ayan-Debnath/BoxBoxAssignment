package com.ayan.boxboxassignmnet.ui.mapper

import com.ayan.boxboxassignmnet.domain.model.RaceScheduleModel
import com.ayan.boxboxassignmnet.ui.screens.details.RaceDetailsUiModel
import com.ayan.boxboxassignmnet.utils.HelperFunction.convertEpochToDateRange
import com.ayan.boxboxassignmnet.utils.HelperFunction.getTimeRemaining


fun RaceScheduleModel.toUiModel(): RaceDetailsUiModel{
    return RaceDetailsUiModel(
        roundName = "Round $round",
        raceName = raceName,
        circuitId = circuitId,
        date = convertEpochToDateRange(startTime, endTime),
        startsIn = getTimeRemaining(startTime)
    )
}
