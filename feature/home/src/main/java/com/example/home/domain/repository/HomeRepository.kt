package com.example.home.domain.repository

import com.example.core.data.local.LocationData
import com.example.core.domain.DataError
import com.example.core.domain.Result
import com.example.home.domain.model.ForecastModel
import com.example.core.domain.model.WeatherModel
import kotlinx.coroutines.flow.Flow

/**
 * created by Karim Haggagi Hassan Elsayed on 2/3/25
 **/
interface HomeRepository {
    suspend fun getCurrentWeatherData(lat: Double, lon: Double): Result<WeatherModel, DataError.Remote>
    suspend fun getForecastData(lat: Double, lon: Double): Result<ForecastModel, DataError.Remote>
    fun getLocation():Flow<LocationData>
}