package com.example.data.repoImpl.search

import com.example.data.fake.fakeWeatherDto
import com.example.data.fake.fakeWeatherModel
import com.example.data.search.SearchRepoImpl
import com.example.data.toWeatherEntity
import com.example.network.RemoteDataSource
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
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
class SearchRepoImplTest {
    @Mock
    private lateinit var remoteDataSource: RemoteDataSource

    @Mock
    private lateinit var localDataSource: com.example.data_base.LocalDataSource

    private lateinit var SUT: SearchRepoImpl

    @Before
    fun setup() {
        SUT = SearchRepoImpl(remoteDataSource, localDataSource)
    }

    @Test
    fun search_CityBy_Name_return_Success() = runTest {
        searchCity()
        val result = SUT.getWeatherByCityName("San Francisco")
        assertTrue(result is com.example.common.Result.Success)
        assertEquals((result as com.example.common.Result.Success).data.name, "San Francisco")

    }

    @Test
    fun save_Location_return_Success() = runTest {
        saveLocation()
        val result = SUT.getCashedList().first()
        assertEquals(result.first().name, "San Francisco")
    }

    private suspend fun searchCity() {
        whenever(remoteDataSource.getWeatherByCityName(any())).thenReturn(
            com.example.common.Result.Success(
                fakeWeatherDto
            )
        )
    }

    private suspend fun saveLocation() {
        whenever(localDataSource.getCashedList()).thenReturn(
            flowOf(listOf(fakeWeatherModel.toWeatherEntity()))
        )
    }
}