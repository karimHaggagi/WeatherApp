package com.example.data.home

import com.example.model.domainmodel.LocationData
import com.example.model.domainmodel.ForecastModel
import com.example.model.domainmodel.WeatherModel
import com.example.model.toForecastDomainModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import com.example.common.*
import com.example.data_store.SettingsDataSource
import com.example.model.toWeatherDomainModel
import com.example.network.RemoteDataSource

/**
 * created by Karim Haggagi Hassan Elsayed on 2/3/25
 **/
class HomeRepoImp @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val settingsDataSource: SettingsDataSource
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
        return settingsDataSource.getLocation()
    }
}