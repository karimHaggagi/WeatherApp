package com.example.home.presentation

import com.example.ui.UiText
import com.example.model.domainmodel.ForecastModelItem
import com.example.model.domainmodel.HourlyForecast
import com.example.model.domainmodel.WeatherModel
import com.example.model.WeatherCondition
import com.example.model.WeatherUi
import com.example.model.formatDate

/**
 * created by Karim Haggagi Hassan Elsayed on 2/4/25
 **/
sealed interface WeatherUiState {
    data object Loading : WeatherUiState
    data class Error(val error: UiText) : WeatherUiState
    data class Success(val weatherUi: WeatherUi, val weatherCondition: WeatherCondition) :
        WeatherUiState
}

sealed interface ForecastUiState {
    data object Loading : ForecastUiState
    data class Error(val error: UiText) : ForecastUiState
    data class Success(val forecast: List<ForecastUi>) : ForecastUiState
}

data class ForecastUi(
    val weather: WeatherUi = WeatherUi(),
    val weatherCondition: WeatherCondition = WeatherCondition(),
    val hourlyForecast: List<HourlyForecast> = emptyList()
)

fun WeatherModel.asSuccessHomeState() = WeatherUiState.Success(
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
    )
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

