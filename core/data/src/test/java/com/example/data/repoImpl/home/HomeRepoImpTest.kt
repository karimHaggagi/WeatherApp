package com.example.data.repoImpl.home

import com.example.data.home.HomeRepoImp
import com.example.data.fake.fakeForecastDto
import com.example.data.fake.fakeWeatherDto
import com.example.data.fake.fakeWeatherModel
import com.example.data_store.SettingsDataSource
import com.example.model.toWeatherDomainModel
import com.example.network.RemoteDataSource
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever

/**
 * created by Karim Haggagi Hassan Elsayed on 2/10/25
 */
@RunWith(MockitoJUnitRunner.Silent::class)
class HomeRepoImpTest {

    @Mock
    private lateinit var remoteDataSource: RemoteDataSource

    @Mock
    private lateinit var locationDataSource: SettingsDataSource

    private lateinit var SUT: HomeRepoImp

    @Before
    fun setup() {
        SUT = HomeRepoImp(remoteDataSource, locationDataSource)
    }

    @Test
    fun given_lat_and_long_getCurrentWeather_return_success() = runTest {
        success()
        val result = SUT.getCurrentWeatherData(30.99, 44.99)
        assert(result is com.example.common.Result.Success)
    }

    @Test
    fun given_lat_and_long_getCurrentWeather_return_fail() = runTest {
        fail()
        val result = SUT.getCurrentWeatherData(30.99, 44.99)
        assert(result is com.example.common.Result.Error)
    }

    @Test
    fun given_weatherDto_convert_to_weather_model() {
        val result = fakeWeatherDto.toWeatherDomainModel()
        assert(result == fakeWeatherModel)
    }

    @Test
    fun given_lat_and_long_getForecast_return_success() = runTest {
        successForecast()
        val result = SUT.getForecastData(30.99, 44.99)
        assert(result is com.example.common.Result.Success)
    }

    @Test
    fun given_lat_and_long_getForecast_return_fail() = runTest {
        failForecast()
        val result = SUT.getForecastData(30.99, 44.99)
        assert(result is com.example.common.Result.Error)
    }



    private suspend fun success() {
        whenever(remoteDataSource.getCurrentWeather(any(), any())).thenReturn(
            com.example.common.Result.Success(fakeWeatherDto)
        )
    }

    private suspend fun fail() {
        whenever(remoteDataSource.getCurrentWeather(any(), any())).thenReturn(
            com.example.common.Result.Error(com.example.common.DataError.Remote.SERVER)
        )
    }

    private suspend fun successForecast() {
        whenever(remoteDataSource.getForecast(any(), any())).thenReturn(
            com.example.common.Result.Success(fakeForecastDto)
        )
    }

    private suspend fun failForecast() {
        whenever(remoteDataSource.getForecast(any(), any())).thenReturn(
            com.example.common.Result.Error(com.example.common.DataError.Remote.SERVER)
        )

    }
}