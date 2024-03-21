package com.example.weatherapp.data.repository

import com.example.weatherapp.data.datasource.remote.api.ApiService
import com.example.weatherapp.data.datasource.remote.api.network.NetworkState
import com.example.weatherapp.data.datasource.remote.api.network.makeApiCall
import com.example.weatherapp.domain.repository.HomeRepository
import com.example.weatherapp.data.datasource.remote.api.dto.CurrentWeatherDTO
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val dispatcher: CoroutineDispatcher,
) : HomeRepository {

    override suspend fun getCurrentWeatherByLocation(location: String): Flow<NetworkState<CurrentWeatherDTO>> {
        return makeApiCall(dispatcher) {
            apiService.getCurrentWeatherByLocation(location = location)
        }
    }


}