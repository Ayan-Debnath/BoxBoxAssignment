package com.ayan.boxboxassignmnet.domain.usecase

import android.util.Log
import com.ayan.boxboxassignmnet.domain.model.RaceSessionModel
import com.ayan.boxboxassignmnet.domain.model.isUpComing
import com.ayan.boxboxassignmnet.domain.repository.RaceRepository
import javax.inject.Inject

class ShowUpComingSessionUseCase @Inject constructor(
    private val raceDetailsRepository: RaceRepository
){

    suspend operator fun invoke(): Result<RaceSessionModel>{
        raceDetailsRepository.fetchRaceSession()
            .onSuccess {sessions->
                sessions.forEach {session->
                    if (session.isUpComing()){
                        return Result.success(session)
                    }
                }
            }
        return Result.failure(Exception("No upcoming race found"))
    }

}