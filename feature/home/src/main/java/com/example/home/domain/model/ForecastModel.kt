package com.example.home.domain.model

import androidx.annotation.DrawableRes
import com.example.core.presentation.common.formatTime
import com.example.core.presentation.iconIdForWeatherCondition
import com.example.core.data.remote.dto.Clouds
import com.example.core.data.remote.dto.ForecastSys
import com.example.core.domain.model.Main
import com.example.core.domain.model.Weather
import com.example.core.domain.model.Wind

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
    val weatherIcon: Int get() = iconIdForWeatherCondition(weatherId)
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