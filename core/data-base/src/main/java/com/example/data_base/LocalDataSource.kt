package com.example.data_base

import com.example.data_base.room.WeatherEntity
import kotlinx.coroutines.flow.Flow

/**
 * created by Karim Haggagi Hassan Elsayed on 2/10/25
 **/
interface LocalDataSource {
    suspend fun saveLocationToDatabase(weatherEntity: WeatherEntity)
    fun getCashedList(): Flow<List<WeatherEntity>>
}