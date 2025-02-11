package com.example.home.data.repoImpl

import com.example.core.data.local.LocationData
import com.example.core.data.local.LocationDataSource
import com.example.core.domain.DataError
import com.example.core.domain.Result
import com.example.core.domain.map
import com.example.home.data.datasource.remote.RemoteDataSource
import com.example.core.data.remote.dto.toWeatherDomainModel
import com.example.home.domain.model.ForecastModel
import com.example.core.domain.model.WeatherModel
import com.example.home.data.toForecastDomainModel
import com.example.home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * created by Karim Haggagi Hassan Elsayed on 2/3/25
 **/
class HomeRepoImp @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val locationDataSource: LocationDataSource
) : HomeRepository {

    override suspend fun getCurrentWeatherData(
        lat: Double,
        lon: Double
    ): Result<WeatherModel, DataError.Remote> {
        return remoteDataSource.getCurrentWeather(lat, lon).map { it.toWeatherDomainModel() }
    }

    override suspend fun getForecastData(
        lat: Double,
        lon: Double
    ): Result<ForecastModel, DataError.Remote> {
        return remoteDataSource.getForecast(lat, lon).map { it.toForecastDomainModel() }
    }

    override fun getLocation(): Flow<LocationData> {
        return locationDataSource.getLocation()
    }
}