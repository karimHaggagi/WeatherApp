package com.example.core.presentation.common

import androidx.annotation.DrawableRes
import com.example.core.presentation.getWeatherIconBasedOnId

/**
 * created by Karim Haggagi Hassan Elsayed on 2/10/25
 **/

data class WeatherUi(
 val locationName: String = "",
 val currentTemp: Double = 0.0,
 val minTemp: Double = 0.0,
 val maxTemp: Double = 0.0,
 val weatherId: Int = 0,
 val weather: String = "",
 val date: String = "",
) {
 @get:DrawableRes
 val weatherIcon: Int get() = getWeatherIconBasedOnId(weatherId)
}

data class WeatherCondition(
 val pressure: Int = 0,
 val humidity: Int = 0,
 val windSpeed: Double = 0.0,
 val visibility: Int = 0
)
