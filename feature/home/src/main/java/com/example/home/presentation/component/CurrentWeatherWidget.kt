package com.example.home.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.ui.R
import com.example.model.WeatherUi

/**
 * created by Karim Haggagi Hassan Elsayed on 2/3/25
 **/
@Composable
fun CurrentWeatherWidget(modifier: Modifier = Modifier, state: WeatherUi) {
    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.padding(horizontal = 2.dp, vertical = 2.dp)
            ) {
                Image(
                    imageVector = Icons.Filled.LocationOn,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(16.dp),
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimaryContainer)
                )
                com.example.ui.Subtitle(
                    text = state.locationName
                )
            }
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = modifier
                        .padding(16.dp)
                        .height(100.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val temp = stringResource(
                        id = R.string.format_temperature,
                        state.currentTemp
                    )
                    val highLow = stringResource(
                        id = R.string.format_high_low_temperature,
                        state.maxTemp,
                        state.minTemp
                    )
                    Text(
                        text = temp,
                        style = MaterialTheme.typography.displayMedium.copy(
                            shadow = Shadow(
                                color = Color.Black.copy(alpha = 0.3f),
                                offset = Offset(3f, 3f),
                                blurRadius = 6f
                            )
                        )

                    )
                    Spacer(modifier = Modifier.weight(1f))
                    com.example.ui.SubtitleSmall(
                        text = highLow,
                        modifier = modifier.padding(bottom = 8.dp)
                    )
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier
                        .padding(8.dp)
                        .height(100.dp)
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = state.weatherIcon),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(48.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    com.example.ui.Subtitle(
                        text = state.weather,
                        modifier = modifier
                            .padding(bottom = 8.dp)
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}

@com.example.ui.preview.PreviewLightDarkMode
@Composable
private fun CurrentWeatherWidgetPreview() {
    com.example.ui.theme.WeatherAppTheme {
        CurrentWeatherWidget(state = WeatherUi())
    }
}