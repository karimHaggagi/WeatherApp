package com.example.search.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.ui.R
import com.example.search.presentation.SavedLocations

/**
 * created by Karim Haggagi Hassan Elsayed on 2/10/25
 **/
@Composable
fun SavedItem(modifier: Modifier = Modifier, savedLocations: SavedLocations) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(horizontal = 2.dp, vertical = 0.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = modifier
                        .padding(2.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(
                            R.string.format_temperature,
                            savedLocations.weatherUi.currentTemp
                        ),
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        style = MaterialTheme.typography.displayMedium.copy(
                            shadow = Shadow(
                                color = Color.Black.copy(alpha = 0.3f),
                                offset = Offset(3f, 3f),
                                blurRadius = 6f
                            )
                        )
                    )
                    com.example.ui.SubtitleSmall(
                        text = stringResource(
                            R.string.format_high_low_temperature,
                            savedLocations.weatherUi.maxTemp,
                            savedLocations.weatherUi.minTemp
                        ),
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier.padding(horizontal = 16.dp, vertical = 6.dp)
                ) {
                    Image(
                        painter = painterResource(id = savedLocations.weatherUi.weatherIcon),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(48.dp)
                    )
                    com.example.ui.Subtitle(
                        text = savedLocations.weatherUi.weather,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }

            }
            Row {
                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = modifier.padding(horizontal = 0.dp, vertical = 0.dp)
                ) {
                    com.example.ui.Subtitle(
                        text = savedLocations.weatherUi.locationName,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }
                Spacer(modifier = Modifier.weight(1f))

                com.example.ui.ForecastMoreDetails(condition = savedLocations.weatherCondition)
            }
        }
    }
}

@com.example.ui.preview.PreviewLightDarkMode
@Composable
private fun SavedIemPreview() {
    SavedItem(savedLocations = SavedLocations())
}