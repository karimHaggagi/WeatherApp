package com.example.home.presentation

import app.cash.turbine.test
import com.example.model.domainmodel.LocationData
import com.example.data.home.HomeRepository
import com.example.usecase.GetHourlyNextDaysUseCase
import kotlinx.coroutines.flow.flowOf
import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever
import com.example.model.WeatherUi
import com.example.home.MainDispatcherRule
import com.example.home.fakeForecastDto
import com.example.home.fakeForecastModelItem
import com.example.home.fakeWeatherModel
import com.example.model.toForecastDomainModel
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

/**
 * created by Karim Haggagi Hassan Elsayed on 2/10/25
 */
@RunWith(MockitoJUnitRunner.Silent::class)
class HomeViewModelTest {

    @Mock
    private lateinit var homeRepository: HomeRepository

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var getHourlyNextDaysUseCase: com.example.usecase.GetHourlyNextDaysUseCase
    private lateinit var SUT: HomeViewModel

    @Before
    fun setup() {
        getHourlyNextDaysUseCase = com.example.usecase.GetHourlyNextDaysUseCase(homeRepository)
        SUT = HomeViewModel(homeRepository, getHourlyNextDaysUseCase)
    }

    @Test
    fun given_lat_and_long_call_get_forecast_return_success_weather_and_forecast() = runTest {
        getLocation()


        getCurrentWeather()
        getForecast()

        SUT.currentWeatherStateFlow.test {
            val firstItem = awaitItem()
            assertFalse(firstItem.isLoading)

            assertEquals(
                2 ,
                firstItem.forecast.size
            )
            cancelAndConsumeRemainingEvents()
        }
    }

    @Test
    fun given_lat_and_long_call_get_forecast_return_fail_weather_and_success_forecast() = runTest {
        getLocation()
        failCurrentWeather()
        getForecast()

        SUT.currentWeatherStateFlow.test {
            val firstItem = awaitItem()
            assertEquals(
                firstItem.weatherUi,
                WeatherUi()
            )
            assertEquals(
                firstItem.forecast.first(),
                fakeForecastModelItem.asHomeForecastUi()
            )

            cancelAndConsumeRemainingEvents()
        }
    }

    private fun getLocation() {
        whenever(homeRepository.getLocation()).thenReturn(
            flowOf(LocationData(30.99, 99.10))
        )
    }

    private suspend fun getCurrentWeather() {
        whenever(homeRepository.getCurrentWeatherData(any(), any())).thenReturn(
            com.example.common.Result.Success(fakeWeatherModel)
        )
    }

    private suspend fun failCurrentWeather() {
        whenever(homeRepository.getCurrentWeatherData(any(), any())).thenReturn(
            com.example.common.Result.Error(com.example.common.DataError.Remote.SERVER)
        )
    }

    private suspend fun getForecast() {
        whenever(homeRepository.getForecastData(any(), any())).thenReturn(
            com.example.common.Result.Success(fakeForecastDto.toForecastDomainModel())
        )

    }

}