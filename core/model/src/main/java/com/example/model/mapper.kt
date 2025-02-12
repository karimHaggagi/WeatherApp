package com.example.model

import com.example.model.domainmodel.Coord
import com.example.model.domainmodel.ForecastModel
import com.example.model.domainmodel.ForecastModelItem
import com.example.model.domainmodel.Main
import com.example.model.domainmodel.Weather
import com.example.model.domainmodel.WeatherModel
import com.example.model.domainmodel.Wind
import com.example.model.dto.Clouds
import com.example.model.dto.ForecastDto
import com.example.model.dto.ForecastSys
import com.example.model.dto.WeatherDto

/**
 * created by Karim Haggagi Hassan Elsayed on 2/10/25
 **/
fun ForecastDto.toForecastDomainModel(): ForecastModel {
    return ForecastModel(
        cod = cod ?: 0,
        message = message ?: 0,
        cnt = cnt ?: 0,
        list = list?.map {
            ForecastModelItem(
                dt = it?.dt ?: 0,
                main = Main(
                    feelsLike = it?.main?.feels_like ?: 0.0,
                    grndLevel = it?.main?.grnd_level ?: 0,
                    humidity = it?.main?.humidity ?: 0,
                    pressure = it?.main?.pressure ?: 0,
                    seaLevel = it?.main?.sea_level ?: 0,
                    temp = it?.main?.temp ?: 0.0,
                    tempMax = it?.main?.temp_max ?: 0.0,
                    tempMin = it?.main?.temp_min ?: 0.0
                ),
                visibility = it?.visibility ?: 0,
                weather = it?.weather?.map { weather ->
                    Weather(
                        description = weather?.description ?: "",
                        icon = weather?.icon ?: "",
                        id = weather?.id ?: 0,
                        main = weather?.main ?: ""
                    )
                } ?: emptyList(),
                wind = Wind(
                    deg = it?.wind?.deg ?: 0,
                    gust = it?.wind?.gust ?: 0.0,
                    speed = it?.wind?.speed ?: 0.0
                ),
                clouds = Clouds(
                    all = it?.clouds?.all ?: 0
                ),
                pop = it?.pop ?: 0.0,
                sys = ForecastSys(
                    pod = it?.sys?.pod ?: ""
                ),
                dtTxt = it?.dt_txt ?: "",
                hourlyForecast = emptyList()
            )
        } ?: emptyList()
    )
}

fun WeatherDto.toWeatherDomainModel(): WeatherModel =
    WeatherModel(
        base = base ?: "",
        cod = cod ?: 0,
        coord = Coord(
            lat = coord?.lat ?: 0.0,
            lon = coord?.lon ?: 0.0
        ),
        id = id ?: 0,
        main = Main(
            feelsLike = main?.feels_like ?: 0.0,
            grndLevel = main?.grnd_level ?: 0,
            humidity = main?.humidity ?: 0,
            pressure = main?.pressure ?: 0,
            seaLevel = main?.sea_level ?: 0,
            temp = main?.temp ?: 0.0,
            tempMax = main?.temp_max ?: 0.0,
            tempMin = main?.temp_min ?: 0.0
        ),
        name = name ?: "",
        timezone = timezone ?: 0,
        visibility = visibility ?: 0,
        weather = weather?.map {
            Weather(
                description = it?.description ?: "",
                icon = it?.icon ?: "",
                id = it?.id ?: 0,
                main = it?.main ?: ""
            )
        } ?: emptyList(),
        wind = Wind(
            deg = wind?.deg ?: 0,
            gust = wind?.gust ?: 0.0,
            speed = wind?.speed ?: 0.0
        )

    )