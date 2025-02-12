package com.example.data.search

import com.example.common.map
import com.example.model.domainmodel.WeatherModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import com.example.common.*
import com.example.data.toWeatherEntity
import com.example.data.toWeatherModel
import com.example.model.toWeatherDomainModel
import com.example.network.*
import com.example.data_base.*

/**
 * created by Karim Haggagi Hassan Elsayed on 2/10/25
 **/
class SearchRepoImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) :
    SearchRepo {
    override suspend fun getWeatherByCityName(cityName: String): Result<WeatherModel, DataError.Remote> {
        return remoteDataSource.getWeatherByCityName(cityName).map { it.toWeatherDomainModel() }
    }

    override suspend fun saveLocationToDatabase(weatherModel: WeatherModel) {
        localDataSource.saveLocationToDatabase(weatherModel.toWeatherEntity())

    }

    override fun getCashedList(): Flow<List<WeatherModel>> {
        return localDataSource.getCashedList().map {
            it.map { it.toWeatherModel() }
        }
    }
}