package com.example.network.retrofit

import com.example.common.DataError
import com.example.common.Result
import com.example.model.dto.WeatherDto
import com.example.network.RemoteDataSource
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
    ): Result<com.example.model.dto.ForecastDto, DataError.Remote> {
        return safeCall {
            apiService.getForecast(lat, lon)
        }
    }
    override suspend fun getWeatherByCityName(cityName: String): Result<WeatherDto, DataError.Remote> {
        return safeCall { apiService.getWeatherByCityName(cityName) }
    }
}