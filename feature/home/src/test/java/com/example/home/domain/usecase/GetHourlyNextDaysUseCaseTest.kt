package com.example.home.domain.usecase

import com.example.home.data.fake.fakeForecastDto
import com.example.home.data.toForecastDomainModel
import com.example.home.domain.repository.HomeRepository
import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever
import com.example.core.domain.*
import com.example.core.presentation.common.formatDate
import kotlinx.coroutines.test.runTest
import org.junit.Test

/**
 * created by Karim Haggagi Hassan Elsayed on 2/10/25
 */
@RunWith(MockitoJUnitRunner.Silent::class)
class GetHourlyNextDaysUseCaseTest {

    @Mock
    private lateinit var homeRepository: HomeRepository

    private lateinit var SUT: GetHourlyNextDaysUseCase

    @Before
    fun setup() {
        SUT = GetHourlyNextDaysUseCase(homeRepository)
    }

    @Test
    fun given_lat_and_long_call_get_forecast_return_success() = runTest {
        success()
        val result = SUT(30.99, 99.10)
        assertTrue(result is Result.Success)
        val successData = (result as Result.Success).data

        // Check that current day is not included
        assertTrue(successData.none { it.dtTxt.formatDate() == "2025-02-10" })

        val nextDayForecast = successData.first()
        assertEquals("2025-02-11", nextDayForecast.dtTxt.formatDate())
        assertEquals(1, nextDayForecast.hourlyForecast.size)

    }

    @Test
    fun given_lat_and_long_call_get_forecast_return_fail() = runTest {
        fail()
        val result = SUT(30.99, 99.10)
        assertTrue(result is Result.Error)
    }

    private suspend fun success() {
        whenever(homeRepository.getForecastData(any(), any())).thenReturn(
            Result.Success(fakeForecastDto.toForecastDomainModel())
        )
    }

    private suspend fun fail() {
        whenever(homeRepository.getForecastData(any(), any())).thenReturn(
            Result.Error(DataError.Remote.SERVER)
        )

    }
}