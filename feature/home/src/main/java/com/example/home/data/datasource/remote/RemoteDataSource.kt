package com.example.home.data.datasource.remote

import com.example.core.domain.*
import com.example.core.data.remote.dto.ForecastDto
import com.example.core.data.remote.dto.WeatherDto

/**
 * created by Karim Haggagi Hassan Elsayed on 2/3/25
 **/
interface RemoteDataSource {
    suspend fun getCurrentWeather(lat: Double, lon: Double): Result<WeatherDto, DataError.Remote>
    suspend fun getForecast(lat: Double, lon: Double): Result<ForecastDto, DataError.Remote>

}