package com.example.home.domain.usecase

import com.example.core.domain.DataError
import com.example.core.domain.Result
import com.example.core.domain.map
import com.example.core.presentation.common.formatDate
import com.example.core.presentation.getCurrentDayFormatted
import com.example.home.domain.model.ForecastModelItem
import com.example.home.domain.model.asHourlyForecast
import com.example.home.domain.repository.HomeRepository
import javax.inject.Inject

/**
 * created by Karim Haggagi Hassan Elsayed on 2/9/25
 **/
class GetHourlyNextDaysUseCase @Inject constructor(private val repository: HomeRepository) {
    suspend operator fun invoke(
        lat: Double,
        lon: Double
    ): Result<List<ForecastModelItem>, DataError.Remote> {
        return repository.getForecastData(lat, lon).map { model ->
            val groupedForecast = model.list
                .groupBy { it.dtTxt.formatDate() }
                .filter { it.key != getCurrentDayFormatted() }

            model.list
                .filter { it.dtTxt.formatDate() != getCurrentDayFormatted() }
                .distinctBy { it.dtTxt.formatDate() }
                .map {
                    it.copy(
                        hourlyForecast = groupedForecast.get(it.dtTxt.formatDate())
                            ?.map { it.asHourlyForecast() } ?: emptyList()
                    )
                }
        }
    }
}