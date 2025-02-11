package com.example.search.data.datasource.local

import com.example.core.data.local.database.WeatherEntity
import kotlinx.coroutines.flow.Flow

/**
 * created by Karim Haggagi Hassan Elsayed on 2/10/25
 **/
interface LocalDataSource {
    suspend fun saveLocationToDatabase(weatherEntity: WeatherEntity)
    fun getCashedList(): Flow<List<WeatherEntity>>
}