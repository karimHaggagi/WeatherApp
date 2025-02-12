package com.example.home.presentation.component

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.toggleableState
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import com.example.ui.R
import com.example.model.WeatherUi
import com.example.home.presentation.ForecastUi

/**
 * created by Karim Haggagi Hassan Elsayed on 2/3/25
 **/
@Composable
fun ForecastItem(
    modifier: Modifier = Modifier,
    forecast: ForecastUi
) {
    var expanded by remember { mutableStateOf(false) }

    ElevatedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        ),
        shape = MaterialTheme.shapes.small,
        modifier = modifier
            .padding(vertical = 4.dp, horizontal = 4.dp)
            .animateContentSize()
            .semantics {
                toggleableState = if (expanded) ToggleableState.On else ToggleableState.Off
            }
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(vertical = 4.dp, horizontal = 4.dp)
                .clickable {
                    expanded = !expanded
                }
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = modifier.padding(horizontal = 8.dp, vertical = 0.dp)
            ) {
                Text(
                    text = forecast.weather.date,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = forecast.weather.weather,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(forecast.weather.weatherIcon),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(48.dp)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier.padding(horizontal = 16.dp, vertical = 2.dp)
            ) {
                Text(
                    text = stringResource(
                        id = R.string.format_temperature,
                        forecast.weather.currentTemp
                    ),
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = stringResource(
                        id = R.string.format_high_low_temperature,
                        forecast.weather.maxTemp, forecast.weather.minTemp
                    ),
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
            ExpandItemButton(
                expanded = expanded,
                onClick = {
                    expanded = !expanded
                }
            )
        }
        if (expanded) {
            ForecastMoreDetailsSection(forecastUi = forecast)

        }
    }
}

@com.example.ui.preview.PreviewLightDarkMode
@Composable
private fun ForecastItemPreview() {

    ForecastItem(
        forecast = ForecastUi(
            weather = WeatherUi(
                weather = "conditionText",
                date = "forecastDate",
                maxTemp = 90.0,
                minTemp = 40.0,
                weatherId = com.example.weather.R.drawable.ic_wind
            )
        )
    )
}
