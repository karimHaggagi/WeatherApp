package com.example.data.settings

import com.example.model.domainmodel.LocationData
import kotlinx.coroutines.flow.Flow

/**
 * created by Karim Haggagi Hassan Elsayed on 2/11/25
 **/
interface SettingsRepository {
    suspend fun changeTheme(isDark: Boolean)
    fun getTheme(): Flow<Boolean>


    suspend fun saveLocation(latitude: Double, longitude: Double)
    fun getLocation(): Flow<LocationData>
}