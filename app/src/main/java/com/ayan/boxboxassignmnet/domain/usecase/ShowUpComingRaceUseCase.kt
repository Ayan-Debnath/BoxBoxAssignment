package com.ayan.boxboxassignmnet.domain.usecase

import com.ayan.boxboxassignmnet.domain.model.RaceScheduleModel
import com.ayan.boxboxassignmnet.domain.model.isUpComing
import com.ayan.boxboxassignmnet.domain.repository.RaceRepository
import javax.inject.Inject

class ShowUpComingRaceUseCase @Inject constructor(
    private val raceRepository: RaceRepository
){

    suspend operator fun invoke(): Result<RaceScheduleModel>{
        raceRepository.fetchRaceSchedule()
            .onSuccess { schedules->
                schedules.forEach { schedule->
                    if (schedule.isUpComing()){
                        return Result.success(schedule)
                    }
                }
            }
        return Result.failure(Exception("No upcoming race found"))
    }

}