package com.example.data

import com.example.data_base.room.WeatherEntity
import com.example.model.domainmodel.Coord
import com.example.model.domainmodel.Main
import com.example.model.domainmodel.Weather
import com.example.model.domainmodel.WeatherModel
import com.example.model.domainmodel.Wind

/**
 * created by Karim Haggagi Hassan Elsayed on 2/12/25
 **/

fun WeatherModel.toWeatherEntity(): WeatherEntity {
    return WeatherEntity(
        cityName = this.name,
        weatherName = this.weather[0].main,
        visibility = this.visibility,
        humidity = this.main.humidity,
        pressure = this.main.pressure,
        tempMax = this.main.tempMax,
        tempMin = this.main.tempMin,
        weatherId = this.weather[0].id,
        windSpeed = this.wind.speed,
        temp = this.main.temp
    )
}

fun WeatherEntity.toWeatherModel(): WeatherModel {
    return WeatherModel(
        name = this.cityName,
        weather = listOf(
            Weather(
                main = this.weatherName,
                id = this.weatherId,
                description = "",
                icon = ""
            )
        ),
        visibility = this.visibility,
        main = Main(
            humidity = this.humidity,
            pressure = this.pressure,
            tempMax = this.tempMax,
            tempMin = this.tempMin,
            seaLevel = 0,
            grndLevel = 0,
            feelsLike = 0.0,
            temp = this.temp
        ),
        wind = Wind(speed = this.windSpeed, deg = 0, gust = 0.0),
        cod = 0,
        coord = Coord(0.0, 0.0),
        base = "",
        id = 0,
        timezone = 0
    )
}