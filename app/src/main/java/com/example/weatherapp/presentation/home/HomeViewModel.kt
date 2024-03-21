package com.example.weatherapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.datasource.remote.api.network.NetworkState
import com.example.weatherapp.domain.model.CurrentWeatherModel
import com.example.weatherapp.domain.usecase.GetCurrentWeatherByLocationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getCurrentWeatherByLocationUseCase: GetCurrentWeatherByLocationUseCase) :
    ViewModel() {

    private val _currentLocationFlow: MutableStateFlow<NetworkState<CurrentWeatherModel>> =
        MutableStateFlow(NetworkState.Idle)
    val currentLocationFlow = _currentLocationFlow.asStateFlow()


    fun getCurrentWeatherByLocation(location: String) {
        viewModelScope.launch(Dispatchers.IO) {
            getCurrentWeatherByLocationUseCase(location).collectLatest {
                _currentLocationFlow.emit(it)
            }
        }
    }
}