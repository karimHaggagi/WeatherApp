package com.example.home.data.datasource.remote

import com.example.core.data.remote.WeatherApiService
import com.example.core.data.remote.safeCall
import com.example.core.domain.DataError
import com.example.core.domain.Result
import com.example.core.data.remote.dto.ForecastDto
import com.example.core.data.remote.dto.WeatherDto
import javax.inject.Inject

/**
 * created by Karim Haggagi Hassan Elsayed on 2/4/25
 **/
class RetrofitRemoteDataSource @Inject constructor(private val apiService: WeatherApiService) :
    RemoteDataSource {

    override suspend fun getCurrentWeather(
        lat: Double,
        lon: Double
    ): Result<WeatherDto, DataError.Remote> {
        return safeCall {
            apiService.getCurrentWeather(lat, lon)
        }
    }

    override suspend fun getForecast(
        lat: Double,
        lon: Double
    ): Result<ForecastDto, DataError.Remote> {
        return safeCall {
            apiService.getForecast(lat, lon)
        }
    }
}