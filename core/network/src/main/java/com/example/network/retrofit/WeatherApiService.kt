package com.example.network.retrofit

import com.example.model.dto.ForecastDto
import com.example.model.dto.WeatherDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * created by Karim Haggagi Hassan Elsayed on 2/4/25
 **/
interface WeatherApiService {

    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double
    ): Response<WeatherDto>

    @GET("forecast")
    suspend fun getForecast(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double
    ): Response<ForecastDto>

    @GET("weather")
    suspend fun getWeatherByCityName(
        @Query("q") cityName: String,
    ): Response<WeatherDto>

    companion object {
        const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    }
}