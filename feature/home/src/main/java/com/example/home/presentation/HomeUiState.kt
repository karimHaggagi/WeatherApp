package com.example.home.presentation

import com.example.core.presentation.UiText
import com.example.core.presentation.common.formatDate
import com.example.home.domain.model.ForecastModelItem
import com.example.home.domain.model.HourlyForecast
import com.example.core.domain.model.WeatherModel
import com.example.core.presentation.common.WeatherCondition
import com.example.core.presentation.common.WeatherUi

/**
 * created by Karim Haggagi Hassan Elsayed on 2/4/25
 **/
data class HomeUiState(
    val isLoading: Boolean = true,
    val hasError: UiText? = null,
    val weatherUi: WeatherUi = WeatherUi(),
    val weatherCondition: WeatherCondition = WeatherCondition(),
    val forecast: List<ForecastUi> = emptyList()
)

data class ForecastUi(
    val weather: WeatherUi = WeatherUi(),
    val weatherCondition: WeatherCondition = WeatherCondition(),
    val hourlyForecast: List<HourlyForecast> = emptyList()
)

fun WeatherModel.asHomeUiState() = HomeUiState(
    weatherUi = WeatherUi(
        locationName = name,
        currentTemp = main.temp,
        minTemp = main.tempMin,
        maxTemp = main.tempMax,
        weather = weather[0].main,
        weatherId = weather[0].id,
    ),
    weatherCondition = WeatherCondition(
        pressure = main.pressure,
        humidity = main.humidity,
        windSpeed = wind.speed,
        visibility = visibility
    ),
    isLoading = false,
    hasError = null
)

fun ForecastModelItem.asHomeForecastUi(): ForecastUi {
    return ForecastUi(
        weather = WeatherUi(
            locationName = "",
            currentTemp = main.temp,
            minTemp = main.tempMin,
            maxTemp = main.tempMax,
            weather = weather[0].main,
            date = dtTxt.formatDate()
        ),
        weatherCondition = WeatherCondition(
            pressure = main.pressure,
            humidity = main.humidity,
            windSpeed = wind.speed,
            visibility = visibility
        ),
        hourlyForecast = hourlyForecast.filterNotNull()
    )
}

