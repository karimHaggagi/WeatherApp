package com.example.search.domain.repo

import com.example.core.data.local.database.WeatherEntity
import com.example.core.domain.*
import com.example.core.domain.model.WeatherModel
import kotlinx.coroutines.flow.Flow

/**
 * created by Karim Haggagi Hassan Elsayed on 2/10/25
 **/
interface SearchRepo {
    suspend fun getWeatherByCityName(cityName: String): Result<WeatherModel, DataError.Remote>
    suspend fun saveLocationToDatabase(weatherModel: WeatherModel)
    fun getCashedList(): Flow<List<WeatherModel>>
}