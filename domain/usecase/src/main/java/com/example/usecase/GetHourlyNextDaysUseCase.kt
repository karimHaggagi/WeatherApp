package com.example.usecase

import com.example.common.DataError
import com.example.common.Result
import com.example.common.map
import com.example.model.domainmodel.ForecastModelItem
import com.example.model.domainmodel.asHourlyForecast
import com.example.data.home.HomeRepository
import com.example.utils.formatDate
import com.example.utils.getCurrentDayFormatted
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