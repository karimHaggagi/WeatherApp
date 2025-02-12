package com.example.data.settings

import com.example.data_store.SettingsDataSource
import com.example.model.domainmodel.LocationData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * created by Karim Haggagi Hassan Elsayed on 2/11/25
 **/
class SettingsRepoImp @Inject constructor(private val settingsDataSource: SettingsDataSource) :
    SettingsRepository {
    override suspend fun changeTheme(isDark: Boolean) {
        settingsDataSource.changeTheme(isDark)
    }

    override fun getTheme(): Flow<Boolean> {
        return settingsDataSource.getTheme()
    }

    override suspend fun saveLocation(latitude: Double, longitude: Double) {
        settingsDataSource.saveLocation(latitude, longitude)
    }

    override fun getLocation(): Flow<LocationData> {
        return settingsDataSource.getLocation()
    }
}