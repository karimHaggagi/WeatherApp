package com.example.weatherapp.presentation.forecast

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.datasource.remote.api.network.NetworkState
import com.example.weatherapp.domain.model.ForecastModel
import com.example.weatherapp.domain.usecase.GetNextFiveDaysUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(private val getNextFiveDaysUseCase: GetNextFiveDaysUseCase) : ViewModel() {
    private val _forecastFlow: MutableStateFlow<NetworkState<ForecastModel>> =
        MutableStateFlow(NetworkState.Idle)
    val forecastFlow = _forecastFlow.asStateFlow()


    fun getNextFiveDays(location: String) {
        viewModelScope.launch(Dispatchers.IO) {
            getNextFiveDaysUseCase(location).collectLatest {
                _forecastFlow.emit(it)
            }
        }
    }

}