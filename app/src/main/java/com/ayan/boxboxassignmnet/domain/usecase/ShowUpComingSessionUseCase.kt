package com.ayan.boxboxassignmnet.domain.usecase

import com.ayan.boxboxassignmnet.domain.repository.RaceDetailsRepository
import javax.inject.Inject

class ShowUpComingSessionUseCase @Inject constructor(
    private val raceDetailsRepository: RaceDetailsRepository
){

    suspend operator fun invoke(){
        raceDetailsRepository.fetchUpcomingSessionDetails()
            .onSuccess {  }
    }

}