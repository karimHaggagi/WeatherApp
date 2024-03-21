package com.example.weatherapp.domain.usecase

import com.example.weatherapp.data.datasource.remote.api.network.NetworkState
import com.example.weatherapp.data.datasource.remote.api.network.mapResultTo
import com.example.weatherapp.domain.model.ForecastModel
import com.example.weatherapp.domain.model.asForecastModel
import com.example.weatherapp.domain.repository.ForecastRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNextFiveDaysUseCase @Inject constructor(private val forecastRepository: ForecastRepository) {
    suspend operator fun invoke(location: String): Flow<NetworkState<ForecastModel>> {
        return forecastRepository.getNextFiveDaysWeather(location).mapResultTo { forecastDTO ->
            forecastDTO.asForecastModel()
        }
    }
}