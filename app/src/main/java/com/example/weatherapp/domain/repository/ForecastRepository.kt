package com.example.weatherapp.domain.repository

import com.example.weatherapp.data.datasource.remote.api.dto.CurrentWeatherDTO
import com.example.weatherapp.data.datasource.remote.api.dto.ForecastDTO
import com.example.weatherapp.data.datasource.remote.api.network.NetworkState
import kotlinx.coroutines.flow.Flow

interface ForecastRepository {
    suspend fun getNextFiveDaysWeather(location: String): Flow<NetworkState<ForecastDTO>>

}