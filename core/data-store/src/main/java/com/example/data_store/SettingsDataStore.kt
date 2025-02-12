package com.example.data_store

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.model.domainmodel.LocationData
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * created by Karim Haggagi Hassan Elsayed on 2/11/25
 **/
val Context.settingsDataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SettingsDataStore @Inject constructor(@ApplicationContext private val context: Context) :
    SettingsDataSource {
    // Keys for latitude and longitude
    companion object {
        val DARK_THEME = booleanPreferencesKey("dark_theme")
        val LATITUDE_KEY = doublePreferencesKey("latitude")
        val LONGITUDE_KEY = doublePreferencesKey("longitude")
    }

    override suspend fun changeTheme(isDark: Boolean) {
        context.settingsDataStore.edit { preferences ->
            preferences[DARK_THEME] = isDark
        }
    }

    override fun getTheme(): Flow<Boolean> {
        return darkThemeFlow
    }

    // Save location data
    override suspend fun saveLocation(latitude: Double, longitude: Double) {
        context.settingsDataStore.edit { preferences ->
            preferences[LATITUDE_KEY] = latitude
            preferences[LONGITUDE_KEY] = longitude
        }
    }

    override fun getLocation(): Flow<LocationData> {
        return locationFlow
    }

    // Get location data as Flow
    private val locationFlow: Flow<LocationData> = context.settingsDataStore.data
        .map { preferences ->
            val latitude = preferences[LATITUDE_KEY] ?: 0.0
            val longitude = preferences[LONGITUDE_KEY] ?: 0.0
            LocationData(latitude, longitude)
        }
    // Get location data as Flow
    private val darkThemeFlow: Flow<Boolean> = context.settingsDataStore.data
        .map { preferences ->
            preferences[DARK_THEME] ?: false

        }

}