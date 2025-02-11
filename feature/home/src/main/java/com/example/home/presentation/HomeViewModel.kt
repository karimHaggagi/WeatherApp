package com.example.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.local.LocationData
import com.example.core.domain.onError
import com.example.core.domain.onSuccess
import com.example.core.presentation.toUiText
import com.example.home.domain.repository.HomeRepository
import com.example.home.domain.usecase.GetHourlyNextDaysUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
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

    private val _currentWeatherStateFlow = MutableStateFlow(HomeUiState())
    val currentWeatherStateFlow = _currentWeatherStateFlow
        .onStart {
            getCurrentWeather()
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            HomeUiState()
        )

    private var locationJob: Job? = null

    private fun getCurrentWeather() {
        viewModelScope.launch {
            repo.getLocation().collectLatest { locationData ->
                locationJob?.cancel()

                locationJob = viewModelScope.launch {
                    val currentWeatherDeferred = async {
                        repo.getCurrentWeatherData(
                            locationData.latitude,
                            locationData.longitude
                        )
                    }
                    val hourlyForecastDeferred = async {
                        getHourlyNextDaysUseCase(locationData.latitude, locationData.longitude)
                    }

                    val currentWeatherResult = currentWeatherDeferred.await()
                    val hourlyForecastResult = hourlyForecastDeferred.await()

                    currentWeatherResult.onSuccess { model ->
                        _currentWeatherStateFlow.update { model.asHomeUiState() }
                    }.onError { error ->
                        _currentWeatherStateFlow.update {
                            it.copy(
                                isLoading = false,
                                hasError = error.toUiText()
                            )
                        }
                    }

                    hourlyForecastResult.onSuccess { model ->
                        _currentWeatherStateFlow.update { it.copy(forecast = model.map { it.asHomeForecastUi() }) }
                    }.onError { error ->
                        _currentWeatherStateFlow.update {
                            it.copy(
                                isLoading = false,
                                hasError = error.toUiText()
                            )
                        }
                    }
                }
            }
        }
    }

    fun hideError() {
        viewModelScope.launch {
            _currentWeatherStateFlow.update { it.copy(hasError = null) }
        }
    }
}