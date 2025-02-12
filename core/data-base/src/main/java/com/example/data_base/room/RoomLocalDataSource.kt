package com.example.data_base.room

import com.example.data_base.LocalDataSource
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