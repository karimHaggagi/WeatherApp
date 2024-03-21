package com.example.weatherapp.data.repository

import com.example.weatherapp.data.datasource.remote.api.ApiService
import com.example.weatherapp.data.datasource.remote.api.dto.CurrentWeatherDTO
import com.example.weatherapp.data.datasource.remote.api.dto.ForecastDTO
import com.example.weatherapp.data.datasource.remote.api.network.NetworkState
import com.example.weatherapp.data.datasource.remote.api.network.makeApiCall
import com.example.weatherapp.domain.repository.ForecastRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ForecastRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val dispatchers: CoroutineDispatcher
) : ForecastRepository {
    override suspend fun getNextFiveDaysWeather(location: String): Flow<NetworkState<ForecastDTO>> {
        return makeApiCall(dispatchers){
            apiService.getForecast(location = location)
        }
    }

}