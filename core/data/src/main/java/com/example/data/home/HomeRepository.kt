package com.example.data.home

import com.example.model.domainmodel.LocationData
import com.example.common.DataError
import com.example.common.Result
import com.example.model.domainmodel.ForecastModel
import com.example.model.domainmodel.WeatherModel
import kotlinx.coroutines.flow.Flow

/**
 * created by Karim Haggagi Hassan Elsayed on 2/3/25
 **/
interface HomeRepository {
    suspend fun getCurrentWeatherData(lat: Double, lon: Double): Result<WeatherModel, DataError.Remote>
    suspend fun getForecastData(lat: Double, lon: Double): Result<ForecastModel, DataError.Remote>
    fun getLocation():Flow<LocationData>
}