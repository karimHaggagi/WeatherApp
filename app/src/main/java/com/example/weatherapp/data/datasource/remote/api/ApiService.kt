package com.example.weatherapp.data.datasource.remote.api

import com.example.weatherapp.BuildConfig
import com.example.weatherapp.data.datasource.remote.api.dto.CurrentWeatherDTO
import com.example.weatherapp.data.datasource.remote.api.dto.ForecastDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET(EndPoint.CURRENT)
    suspend fun getCurrentWeatherByLocation(
        @Query("key") key: String = BuildConfig.API_KEY,
        @Query("q") location: String,
        @Query("aqi") aqi: String = "no"
    ): CurrentWeatherDTO

    @GET(EndPoint.FORECAST)
    suspend fun getForecast(
        @Query("key") key: String = BuildConfig.API_KEY,
        @Query("q") location: String,
        @Query("days") days: Int = 5,
        @Query("aqi") aqi: String = "no",
        @Query("alerts") alerts: String = "no",
    ): ForecastDTO

}