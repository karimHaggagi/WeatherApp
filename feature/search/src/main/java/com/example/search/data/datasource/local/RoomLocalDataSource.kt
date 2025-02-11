package com.example.search.data.datasource.local

import com.example.core.data.local.database.WeatherDao
import com.example.core.data.local.database.WeatherEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * created by Karim Haggagi Hassan Elsayed on 2/10/25
 **/
class RoomLocalDataSource @Inject constructor(private val weatherDao: WeatherDao) :
    LocalDataSource {
    override suspend fun saveLocationToDatabase(weatherEntity: WeatherEntity) {
        weatherDao.insertWeather(weatherEntity)
    }

    override fun getCashedList(): Flow<List<WeatherEntity>> {
        return weatherDao.getAllWeather()
    }
}