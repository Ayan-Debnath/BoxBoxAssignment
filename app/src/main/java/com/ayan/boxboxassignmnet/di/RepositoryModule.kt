package com.ayan.boxboxassignmnet.di

import com.ayan.boxboxassignmnet.data.repository.DriverRepositoryImpl
import com.ayan.boxboxassignmnet.data.repository.RaceRepositoryImpl
import com.ayan.boxboxassignmnet.domain.repository.DriverRepository
import com.ayan.boxboxassignmnet.domain.repository.RaceRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindsDriverRepository(
        driverRepositoryImpl: DriverRepositoryImpl
    ): DriverRepository

    @Binds
    abstract fun bindsRaceRepository(
       raceRepositoryImpl: RaceRepositoryImpl
    ): RaceRepository

}