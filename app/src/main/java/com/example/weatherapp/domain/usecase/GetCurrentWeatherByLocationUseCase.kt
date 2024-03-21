package com.example.weatherapp.domain.usecase

import com.example.weatherapp.data.datasource.remote.api.network.NetworkState
import com.example.weatherapp.data.datasource.remote.api.network.mapResultTo
import com.example.weatherapp.domain.model.CurrentWeatherModel
import com.example.weatherapp.domain.model.asCurrentWeatherModel
import com.example.weatherapp.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCurrentWeatherByLocationUseCase @Inject constructor(private val homeRepository: HomeRepository) {
    suspend operator fun  invoke(location: String): Flow<NetworkState<CurrentWeatherModel>> {
        return homeRepository.getCurrentWeatherByLocation(location)
            .mapResultTo { currentWeatherDTO ->
                currentWeatherDTO.asCurrentWeatherModel()
            }
    }
}