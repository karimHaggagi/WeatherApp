package com.example.search.presentation

import com.example.model.domainmodel.WeatherModel
import com.example.ui.UiText
import com.example.model.WeatherCondition
import com.example.model.WeatherUi

/**
 * created by Karim Haggagi Hassan Elsayed on 2/10/25
 **/
data class SearchUiState(
    val isLoading: Boolean = false,
    val cityName: String = "",
    val weatherUi: WeatherUi? = null,
    val weatherCondition: WeatherCondition = WeatherCondition(),
    val hasError: UiText? = null,
    val savedLocations: List<SavedLocations> = emptyList()
)

data class SavedLocations(
    val cityName: String = "",
    val weatherUi: WeatherUi = WeatherUi(),
    val weatherCondition: WeatherCondition = WeatherCondition(),
)

fun WeatherModel.asSearchUiState() = SearchUiState(
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

fun WeatherModel.asSavedLocations() =
    SavedLocations(
        cityName = name,
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
