package com.example.home.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.presentation.component.ForecastMoreDetails
import com.example.core.presentation.preview.PreviewLightDarkMode
import com.example.home.presentation.ForecastUi

/**
 * created by Karim Haggagi Hassan Elsayed on 2/3/25
 **/
@Composable
fun ForecastMoreDetailsSection(modifier: Modifier = Modifier, forecastUi: ForecastUi) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(horizontal = 1.dp, vertical = 4.dp)
            .fillMaxWidth()
    ) {
        ForecastMoreDetails(condition = forecastUi.weatherCondition)
        HourlyDataElementRow(hourlyForecast = forecastUi.hourlyForecast)
    }
}

@PreviewLightDarkMode
@Composable
private fun ForecastMoreDetailsSectionPreview() {
    ForecastMoreDetailsSection(forecastUi = ForecastUi())
}