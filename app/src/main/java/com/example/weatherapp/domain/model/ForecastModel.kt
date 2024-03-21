package com.example.weatherapp.domain.model

import com.example.weatherapp.data.datasource.remote.api.dto.Condition
import com.example.weatherapp.data.datasource.remote.api.dto.ForecastDTO

data class ForecastModel(
    val forecast: List<ForecastDayModel>,
)

data class ForecastDayModel(
    val date: String,
    val day: DayModel,
)

data class DayModel(
    val avghumidity: String,
    val avgvis_km: String,
    val avgvis_miles: Double,
    val condition: ConditionModel,
    val temp_c: String,
    val temp_f: String,
    val maxwind_kph: String,
    val maxwind_mph: Double,
)

fun ForecastDTO.asForecastModel() = ForecastModel(
    forecast = forecast?.forecastday?.map { forecast ->
        ForecastDayModel(
            date = forecast.date?:"",
            day = DayModel(
                avghumidity = (forecast.day?.avghumidity?.toString()?:"0") + " %",
                avgvis_km = (forecast.day?.avgvis_km?.toString()?:"0") + " km",
                avgvis_miles = forecast.day?.avgvis_miles?:0.0,
                condition = ConditionModel(icon = ("https:" + forecast.day?.condition?.icon) ?: "", text = forecast.day?.condition?.text?:""),
                temp_c = "${forecast.day?.maxtemp_c?:0.0} - ${forecast.day?.mintemp_c?:0.0}",
                temp_f = "${forecast.day?.maxtemp_f?:0.0} - ${forecast.day?.mintemp_f?:0.0}",
                maxwind_kph= (forecast.day?.maxwind_kph?.toString()?: "0") +" km" ,
                maxwind_mph = forecast.day?.maxwind_mph?:0.0,
            )
        )
    } ?: emptyList<ForecastDayModel>()
)