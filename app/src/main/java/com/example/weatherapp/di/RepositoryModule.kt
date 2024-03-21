package com.example.weatherapp.di

import com.example.weatherapp.data.repository.ForecastRepositoryImpl
import com.example.weatherapp.data.repository.HomeRepositoryImpl
import com.example.weatherapp.domain.repository.ForecastRepository
import com.example.weatherapp.domain.repository.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideHomeRepository(homeRepositoryImpl: HomeRepositoryImpl): HomeRepository =
        homeRepositoryImpl


    @Provides
    @Singleton
    fun provideForecastRepository(forecastRepositoryImpl: ForecastRepositoryImpl): ForecastRepository =
        forecastRepositoryImpl
}