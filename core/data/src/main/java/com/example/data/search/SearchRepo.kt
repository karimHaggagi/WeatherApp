package com.example.data.search

import com.example.model.domainmodel.WeatherModel
import kotlinx.coroutines.flow.Flow

/**
 * created by Karim Haggagi Hassan Elsayed on 2/10/25
 **/
interface SearchRepo {
    suspend fun getWeatherByCityName(cityName: String): com.example.common.Result<WeatherModel, com.example.common.DataError.Remote>
    suspend fun saveLocationToDatabase(weatherModel: WeatherModel)
    fun getCashedList(): Flow<List<WeatherModel>>
}