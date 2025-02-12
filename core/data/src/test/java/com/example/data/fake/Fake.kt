package com.example.data.fake

import com.example.model.domainmodel.Coord
import com.example.model.domainmodel.Main
import com.example.model.domainmodel.Weather
import com.example.model.domainmodel.WeatherModel
import com.example.model.domainmodel.Wind
import com.example.model.domainmodel.ForecastModelItem
import com.example.model.domainmodel.HourlyForecast
import com.example.model.dto.Clouds
import com.example.model.dto.ForecastSys
import com.example.model.dto.WeatherDto

/**
 * created by Karim Haggagi Hassan Elsayed on 2/10/25
 **/
val fakeWeatherDto = WeatherDto(
    base = "stations",
    clouds = Clouds(all = 20),
    cod = 200,
    coord = com.example.model.dto.Coord(lat = 37.7749, lon = -122.4194),
    dt = 1638316800,
    id = 5391959,
    main = com.example.model.dto.Main(
        feels_like = 15.0,
        grnd_level = 1012,
        humidity = 75,
        pressure = 1015,
        sea_level = 1018,
        temp = 18.0,
        temp_max = 20.0,
        temp_min = 16.0
    ),
    name = "San Francisco",
    sys = com.example.model.dto.Sys(
        country = "US",
        id = 5122,
        sunrise = 1638266400,
        sunset = 1638302400,
        type = 1
    ),
    timezone = -28800,
    visibility = 10000,
    weather = listOf(
        com.example.model.dto.Weather(
            description = "clear sky",
            icon = "01d",
            id = 800,
            main = "Clear"
        )
    ),
    wind = com.example.model.dto.Wind(
        deg = 350,
        gust = 5.0,
        speed = 3.6
    )
)

val fakeWeatherModel = WeatherModel(
    base = "stations",
    cod = 200,
    coord = Coord(lat = 37.7749, lon = -122.4194),
    id = 5391959,
    main = Main(
        feelsLike = 15.0,
        grndLevel = 1012,
        humidity = 75,
        pressure = 1015,
        seaLevel = 1018,
        temp = 18.0,
        tempMax = 20.0,
        tempMin = 16.0
    ),
    name = "San Francisco",
    timezone = -28800,
    visibility = 10000,
    weather = listOf(
       Weather(
            description = "clear sky",
            icon = "01d",
            id = 800,
            main = "Clear"
        )
    ),
    wind = Wind(
        deg = 350,
        gust = 5.0,
        speed = 3.6
    )
)

val fakeForecastDto = com.example.model.dto.ForecastDto(
    cod = 200,
    message = 0,
    cnt = 5,
    list = listOf(
        com.example.model.dto.ForecastItem(
            dt = 1638316800,
            main = com.example.model.dto.Main(
                feels_like = 15.0,
                grnd_level = 1012,
                humidity = 75,
                pressure = 1015,
                sea_level = 1018,
                temp = 18.0,
                temp_max = 20.0,
                temp_min = 16.0
            ),
            visibility = 10000,
            weather = listOf(
                com.example.model.dto.Weather(
                    description = "clear sky",
                    icon = "01d",
                    id = 800,
                    main = "Clear"
                )
            ),
            wind = com.example.model.dto.Wind(
                deg = 350,
                gust = 5.0,
                speed = 3.6
            ),
            clouds = Clouds(all = 20),
            pop = 0.0,
            sys = com.example.model.dto.ForecastSys(pod = "d"),
            dt_txt = "2025-02-10 12:00:00"
        ),
        com.example.model.dto.ForecastItem(
            dt = 1638327600,
            main = com.example.model.dto.Main(
                feels_like = 14.0,
                grnd_level = 1013,
                humidity = 80,
                pressure = 1016,
                sea_level = 1019,
                temp = 17.0,
                temp_max = 19.0,
                temp_min = 15.0
            ),
            visibility = 8000,
            weather = listOf(
                com.example.model.dto.Weather(
                    description = "few clouds",
                    icon = "02d",
                    id = 801,
                    main = "Clouds"
                )
            ),
            wind = com.example.model.dto.Wind(
                deg = 340,
                gust = 4.5,
                speed = 3.2
            ),
            clouds = Clouds(all = 40),
            pop = 0.1,
            sys = com.example.model.dto.ForecastSys(pod = "d"),
            dt_txt = "2025-02-11 15:00:00"
        )
    )
)

val fakeForecastModelItem = ForecastModelItem(
    dt = 1638327600,
    dtTxt = "2025-02-10 15:00:00",
    main = Main(
        temp = 18.0,
        feelsLike = 15.0,
        tempMin = 16.0,
        tempMax = 20.0,
        pressure = 1015,
        seaLevel = 1018,
        grndLevel = 1012,
        humidity = 75
    ),
    weather = listOf(
        Weather(
            id = 800,
            main = "Clear",
            description = "clear sky",
            icon = "01d"
        )
    ),
    wind = Wind(
        speed = 3.6,
        deg = 350,
        gust = 5.0
    ),
    clouds = Clouds(all = 20),
    visibility = 10000,
    pop = 0.0,
    sys = ForecastSys(pod = "d"),
    hourlyForecast = listOf(
        HourlyForecast(
            weatherId = 800,
            main = Main(
                temp = 18.0,
                feelsLike = 15.0,
                tempMin = 16.0,
                tempMax = 20.0,
                pressure = 1015,
                seaLevel = 1018,
                grndLevel = 1012,
                humidity = 75
            ),
            hour = "12:00"
        )
    )
)

