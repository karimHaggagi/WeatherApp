package com.example.search.data.datasource.remote

import com.example.core.data.remote.dto.WeatherDto
import com.example.core.domain.*

/**
 * created by Karim Haggagi Hassan Elsayed on 2/10/25
 **/
interface RemoteDataSource {
    suspend fun getWeatherByCityName(cityName: String): Result<WeatherDto, DataError.Remote>
}