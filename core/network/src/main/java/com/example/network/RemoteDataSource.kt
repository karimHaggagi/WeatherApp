package com.example.network

import com.example.common.*
import com.example.model.dto.ForecastDto
import com.example.model.dto.WeatherDto

/**
 * created by Karim Haggagi Hassan Elsayed on 2/3/25
 **/
interface RemoteDataSource {
    suspend fun getCurrentWeather(lat: Double, lon: Double): Result<WeatherDto, DataError.Remote>
    suspend fun getForecast(lat: Double, lon: Double): Result<ForecastDto, DataError.Remote>
    suspend fun getWeatherByCityName(cityName: String): Result<WeatherDto, DataError.Remote>
}