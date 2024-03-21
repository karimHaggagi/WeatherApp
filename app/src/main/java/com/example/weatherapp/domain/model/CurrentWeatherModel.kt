package com.example.weatherapp.domain.model

import com.example.weatherapp.data.datasource.remote.api.dto.CurrentWeatherDTO


data class CurrentWeatherModel(
    val condition: ConditionModel,
    val humidity: String,
    val last_updated: String,
    val temp_c: Double,
    val uv: Double,
    val vis_km: String,
    val vis_miles: Double,
    val wind_degree: Int,
    val wind_dir: String,
    val wind_kph: String,
    val wind_mph: Double,
    val location: LocationModel
)


data class ConditionModel(
    val icon: String,
    val text: String
)

data class LocationModel(
    val country: String,
    val localtime: String,
    val name: String,
    val region: String,
)

fun CurrentWeatherDTO.asCurrentWeatherModel() =
    CurrentWeatherModel(
        humidity = (current?.humidity?.toString() ?: "0") + " %",
        last_updated = current?.last_updated ?: "",
        temp_c = current?.temp_c ?: 0.0,
        uv = current?.uv ?: 0.0,
        vis_km = (current?.vis_km?.toString() ?: "0") + " Km",
        vis_miles = current?.vis_miles ?: 0.0,
        wind_degree = current?.wind_degree ?: 0,
        wind_dir = current?.wind_dir ?: "",
        wind_kph = (current?.wind_kph?.toString() ?: "0") + " Km",
        wind_mph = current?.wind_mph ?: 0.0,
        condition = ConditionModel(
            icon = ("https:" + current?.condition?.icon) ?: "",
            text = current?.condition?.text ?: ""
        ),
        location = LocationModel(
            country = location?.country ?: "",
            localtime = location?.localtime ?: "",
            name = location?.name ?: "",
            region = location?.region ?: ""
        )
    )