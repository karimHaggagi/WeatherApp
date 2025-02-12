package com.example.data_base.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * created by Karim Haggagi Hassan Elsayed on 2/10/25
 **/
@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeather(weather: WeatherEntity)

    @Query("SELECT * FROM weather")
    fun getAllWeather(): Flow<List<WeatherEntity>>

    @Query("DELETE FROM weather WHERE _id = :id")
    suspend fun deleteWeather(id: Int)

}