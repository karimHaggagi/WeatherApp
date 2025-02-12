package com.example.data_base.room

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * created by Karim Haggagi Hassan Elsayed on 2/10/25
 **/
@Database(entities = [WeatherEntity::class], version = 1, exportSchema = false)
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}