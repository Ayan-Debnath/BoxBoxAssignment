package com.ayan.boxboxassignmnet.domain.usecase

import com.ayan.boxboxassignmnet.domain.model.DriverModel
import com.ayan.boxboxassignmnet.domain.repository.DriverRepository
import javax.inject.Inject

class FetchDriverUseCase @Inject constructor(
    private val driverRepository: DriverRepository
) {

    suspend operator fun invoke(): Result<DriverModel> {
        driverRepository.fetchDrivers()
            .onSuccess { driverList ->
                driverList.forEach { driver ->
                    if (driver.position == 1) {
                        return Result.success(driver)
                    }
                }
            }
        return Result.failure(Exception("No such driver found"))
    }

}