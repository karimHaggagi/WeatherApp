package com.example.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.model.WeatherCondition
import com.example.ui.preview.PreviewLightDarkMode
import com.example.weather.R

/**
 * created by Karim Haggagi Hassan Elsayed on 2/3/25
 **/
@Composable
fun ForecastMoreDetails(modifier: Modifier = Modifier, condition: WeatherCondition) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(horizontal = 2.dp, vertical = 2.dp)
            .fillMaxWidth()
    ) {
        Column(modifier = modifier.padding(horizontal = 2.dp, vertical = 2.dp)) {
            ConditionsLabelSection(modifier, R.drawable.ic_wind, com.example.ui.R.string.wind_label)
            ConditionsLabelSection(modifier, R.drawable.ic_humidity, com.example.ui.R.string.humidity_label)
            ConditionsLabelSection(modifier, R.drawable.ic_visibility, com.example.ui.R.string.visibility_label)
            ConditionsLabelSection(modifier,R.drawable.ic_pressure, com.example.ui.R.string.pressure_label)
        }
        Column(modifier = modifier.padding(horizontal = 4.dp, vertical = 4.dp)) {
            Text(
                text = "${condition.windSpeed}",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = modifier.padding(horizontal = 4.dp, vertical = 2.dp)
            )
            Text(
                text = "${condition.humidity}",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = modifier.padding(horizontal = 4.dp, vertical = 2.dp)
            )
            Text(
                text = "${condition.visibility}",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = modifier.padding(horizontal = 4.dp, vertical = 2.dp)
            )
            Text(
                text = "${condition.pressure}",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = modifier.padding(horizontal = 4.dp, vertical = 2.dp)
            )
        }
    }

}

@PreviewLightDarkMode
@Composable
private fun ForecastMoreDetailsPreview() {
    ForecastMoreDetails(condition = WeatherCondition())
}