package com.example.search.data.repoImpl

import com.example.core.data.local.database.WeatherEntity
import com.example.core.data.remote.dto.toWeatherDomainModel
import com.example.core.domain.DataError
import com.example.core.domain.Result
import com.example.core.domain.map
import com.example.core.domain.model.WeatherModel
import com.example.search.data.datasource.local.LocalDataSource
import com.example.search.data.datasource.remote.RemoteDataSource
import com.example.search.data.datasource.toWeatherEntity
import com.example.search.data.datasource.toWeatherModel
import com.example.search.domain.repo.SearchRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

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