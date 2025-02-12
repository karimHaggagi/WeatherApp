package com.example.model.domainmodel

import androidx.annotation.DrawableRes
import com.example.model.dto.Clouds
import com.example.model.dto.ForecastSys
import com.example.model.formatTime

/**
 * created by Karim Haggagi Hassan Elsayed on 2/8/25
 **/
data class ForecastModel(
    val cod: Int,
    val message: Int,
    val cnt: Int,
    val list: List<ForecastModelItem>
)

data class ForecastModelItem(
    val dt: Int,
    val main: Main,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind,
    val clouds: Clouds,
    val pop: Double,
    val sys: ForecastSys,
    val dtTxt: String,
    val hourlyForecast: List<HourlyForecast?>
)

data class HourlyForecast(
    val weatherId: Int,
    val main: Main,
    val hour: String
) {

    @get:DrawableRes
    val weatherIcon: Int get() = com.example.weather.iconIdForWeatherCondition(weatherId)
}


fun ForecastModelItem.asHourlyForecast(): HourlyForecast {
    return HourlyForecast(
        weatherId = weather[0].id,
        main = Main(
            feelsLike = main.feelsLike,
            grndLevel = main.grndLevel,
            humidity = main.humidity,
            pressure = main.pressure,
            seaLevel = main.seaLevel,
            temp = main.temp,
            tempMax = main.tempMax,
            tempMin = main.tempMin
        ),
        hour = dtTxt.formatTime()
    )
}