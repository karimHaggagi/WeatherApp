package com.example.weatherapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.settings.SettingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * created by Karim Haggagi Hassan Elsayed on 2/7/25
 **/
@HiltViewModel
class MainViewModel @Inject constructor(
    private val settingsRepository: SettingsRepository,
) :
    ViewModel() {

    val state = mutableStateOf(MainContract.MainUiState())
    val darkThemeFlow =
        settingsRepository.getTheme().stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(500), false
        )

    fun setEvent(event: MainContract.MainEvent) {
        when (event) {
            is MainContract.MainEvent.CheckLocationSettings -> {
                state.value = state.value.copy(isLocationSettingEnabled = event.isEnabled)
            }

            is MainContract.MainEvent.GrantPermission -> {
                state.value = state.value.copy(isPermissionGranted = event.isGranted)
            }

            is MainContract.MainEvent.SaveLocation -> {
                state.value =
                    state.value.copy(userLocation = com.example.model.domainmodel.LocationData(
                        event.latitude,
                        event.longitude
                    )
                    )
                saveLocation(event.latitude, event.longitude)
            }
        }
    }

    private fun saveLocation(latitude: Double, longitude: Double) {
        viewModelScope.launch {
            settingsRepository.saveLocation(latitude, longitude)
        }
    }
}
