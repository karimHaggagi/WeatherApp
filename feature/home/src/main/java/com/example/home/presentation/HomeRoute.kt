package com.example.home.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui.Subtitle
import com.example.home.R
import com.example.home.presentation.component.CurrentWeatherWidget
import com.example.home.presentation.component.ForecastItem
import com.example.ui.OtherConditionsSection
import com.example.ui.preview.PreviewLightDarkMode

/**
 * created by Karim Haggagi Hassan Elsayed on 2/3/25
 **/
@Composable
fun HomeRoute(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val weatherState by viewModel.currentWeatherStateFlow.collectAsStateWithLifecycle()
    val forecastState by viewModel.forecastStateFlow.collectAsStateWithLifecycle()

    HomeScreen(modifier = modifier, state = weatherState, forecastState = forecastState, onRefresh = viewModel::onRefresh)

}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    state: WeatherUiState,
    forecastState: ForecastUiState,
    onRefresh: () -> Unit = {}
) {
    LazyColumn(
        modifier = modifier
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            when (state) {
                is WeatherUiState.Error -> {
                    Subtitle(
                        modifier = Modifier.fillParentMaxSize(0.3f),
                        text = state.error.asString()
                    )
                }

                WeatherUiState.Loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.fillParentMaxSize(0.3f)
                    )
                }

                is WeatherUiState.Success -> {
                    Box {
                        CurrentWeatherWidget(
                            modifier = Modifier,
                            state = state.weatherUi
                        )
                        IconButton(onClick = onRefresh) {
                            Icon(imageVector = Icons.Filled.Refresh, contentDescription = null)
                        }
                    }
                    HorizontalDivider(thickness = 1.dp)
                    OtherConditionsSection(
                        modifier = Modifier.padding(8.dp),
                        state = state.weatherCondition
                    )
                }
            }

            HorizontalDivider(thickness = 1.dp)
            Subtitle(
                text = stringResource(id = R.string.home_weekly_forecast_title)
            )
        }
        when (forecastState) {
            is ForecastUiState.Error -> {
                item {
                    Subtitle(
                        modifier = Modifier.fillMaxHeight(0.5f),
                        text = forecastState.error.asString()
                    )
                }
            }

            ForecastUiState.Loading -> {
                item {
                    CircularProgressIndicator(modifier = Modifier.fillMaxHeight(0.5f))
                }
            }

            is ForecastUiState.Success -> {
                items(items = forecastState.forecast) { forecastItem ->
                    ForecastItem(
                        forecast = forecastItem
                    )
                }
            }
        }
    }
}

@PreviewLightDarkMode
@Composable
private fun HomeScreenPreview() {
    HomeScreen(state = WeatherUiState.Loading, forecastState = ForecastUiState.Loading)
}