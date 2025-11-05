package com.ayan.boxboxassignmnet.ui.mapper

import com.ayan.boxboxassignmnet.domain.model.RaceSessionModel
import com.ayan.boxboxassignmnet.ui.screens.home.SessionUiModel
import com.ayan.boxboxassignmnet.utils.HelperFunction.convertEpochToDateTime

fun RaceSessionModel.toUiModel(): SessionUiModel {
    return SessionUiModel(
        sessionName = sessionName,
        startTime = convertEpochToDateTime(startTime)
    )
}