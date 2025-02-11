package com.example.core.di

import com.example.core.data.local.LocationDataSource
import com.example.core.data.local.LocationDataStore
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * created by Karim Haggagi Hassan Elsayed on 2/7/25
 **/
@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    fun provideLocationDataStore(locationDataStore: LocationDataStore): LocationDataSource
}