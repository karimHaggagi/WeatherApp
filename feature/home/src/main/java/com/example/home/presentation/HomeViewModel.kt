package com.example.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.onError
import com.example.common.onSuccess
import com.example.data.home.HomeRepository
import com.example.model.domainmodel.LocationData
import com.example.usecase.GetHourlyNextDaysUseCase
import com.example.utils.toUiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * created by Karim Haggagi Hassan Elsayed on 2/4/25
 **/
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repo: HomeRepository,
    private val getHourlyNextDaysUseCase: GetHourlyNextDaysUseCase
) : ViewModel() {

    private val _weatherStateFlow = MutableStateFlow<WeatherUiState>(WeatherUiState.Loading)
    val currentWeatherStateFlow = _weatherStateFlow.asStateFlow()

    private val _forecastStateFlow = MutableStateFlow<ForecastUiState>(ForecastUiState.Loading)
    val forecastStateFlow = _forecastStateFlow.asStateFlow()

    private var locationJob: Job? = null
    private var lastLocation: LocationData? = null

    init {
        getLastLocation()
    }

    private fun getLastLocation() {
        viewModelScope.launch {
            repo.getLocation().collectLatest { locationData ->
                lastLocation = locationData
                getData()
            }
        }
    }

    private fun getData(){
        lastLocation?.let {
            locationJob?.cancel()
            locationJob = viewModelScope.launch {
                getCurrentWeather(it)
                getNextDaysForecast(it)
            }
        }
    }

    private suspend fun getCurrentWeather(locationData: LocationData) {
        _weatherStateFlow.emit(WeatherUiState.Loading)
        repo.getCurrentWeatherData(
            locationData.latitude,
            locationData.longitude
        ).onSuccess { response ->
            _weatherStateFlow.emit(response.asSuccessHomeState())
        }.onError { error ->
            _weatherStateFlow.emit(WeatherUiState.Error(error.toUiText()))
        }
    }

    private suspend fun getNextDaysForecast(locationData: LocationData) {
        _forecastStateFlow.emit(ForecastUiState.Loading)
        getHourlyNextDaysUseCase(
            locationData.latitude,
            locationData.longitude
        ).onSuccess { response ->
            _forecastStateFlow.emit(ForecastUiState.Success(response.map { it.asHomeForecastUi() }))
        }.onError { error ->
            _forecastStateFlow.emit(ForecastUiState.Error(error.toUiText()))
        }
    }

    fun onRefresh(){
        getData()
    }
}