package com.example.weatherapp

import com.example.core.data.local.LocationData

/**
 * created by Karim Haggagi Hassan Elsayed on 2/7/25
 **/
class MainContract {

    data class MainUiState(
        val isPermissionGranted: Boolean = false,
        val isLocationSettingEnabled: Boolean = false,
        val userLocation: LocationData? = null
    )

    sealed class MainEvent {
        data class CheckLocationSettings(val isEnabled: Boolean) : MainEvent()
        data class SaveLocation(val latitude: Double, val longitude: Double) : MainEvent()
        data class GrantPermission(val isGranted: Boolean) : MainEvent()
    }
}