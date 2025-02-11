package com.example.search.data.datasource.remote

import com.example.core.data.remote.WeatherApiService
import com.example.core.data.remote.dto.WeatherDto
import com.example.core.data.remote.safeCall
import com.example.core.domain.DataError
import com.example.core.domain.Result
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * created by Karim Haggagi Hassan Elsayed on 2/10/25
 **/
class RetrofitRemoteDataSource @Inject constructor(private val apiService: WeatherApiService) :
    RemoteDataSource {
    override suspend fun getWeatherByCityName(cityName: String): Result<WeatherDto, DataError.Remote> {
        return safeCall { apiService.getWeatherByCityName(cityName) }
    }

}