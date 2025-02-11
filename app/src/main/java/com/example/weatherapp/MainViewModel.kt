package com.example.weatherapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.local.LocationData
import com.example.core.data.local.LocationDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * created by Karim Haggagi Hassan Elsayed on 2/7/25
 **/
@HiltViewModel
class MainViewModel @Inject constructor(private val locationDataStore: LocationDataSource) :
    ViewModel() {

    val state = mutableStateOf(MainContract.MainUiState())

    fun setEvent(event: MainContract.MainEvent) {
        when(event){
            is MainContract.MainEvent.CheckLocationSettings -> {
                state.value = state.value.copy(isLocationSettingEnabled = event.isEnabled)
            }
            is MainContract.MainEvent.GrantPermission -> {
                state.value = state.value.copy(isPermissionGranted = event.isGranted)
            }
            is MainContract.MainEvent.SaveLocation -> {
                state.value = state.value.copy(userLocation = LocationData(event.latitude, event.longitude))
                saveLocation(event.latitude, event.longitude)
            }
        }
    }
    private fun saveLocation(latitude: Double, longitude: Double) {
        viewModelScope.launch {
            locationDataStore.saveLocation(latitude, longitude)
        }
    }
}
