package com.example.core.data.local

import kotlinx.coroutines.flow.Flow

/**
 * created by Karim Haggagi Hassan Elsayed on 2/7/25
 **/
interface LocationDataSource {
    suspend fun saveLocation(latitude: Double, longitude: Double)
    fun getLocation(): Flow<LocationData>
}