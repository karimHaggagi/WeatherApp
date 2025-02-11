package com.example.home.presentation

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.core.presentation.ScreenContainer
import com.example.core.presentation.component.Subtitle
import com.example.home.R
import com.example.home.presentation.component.CurrentWeatherWidget
import com.example.home.presentation.component.ForecastItem
import com.example.home.presentation.component.OtherConditionsSection

/**
 * created by Karim Haggagi Hassan Elsayed on 2/3/25
 **/
@Composable
fun HomeRoute(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.currentWeatherStateFlow.collectAsStateWithLifecycle()

    ScreenContainer(
        modifier = modifier.fillMaxSize(),
        isLoading = state.isLoading,
        errorDialogText = state.hasError,
        onDialogButtonClick = {
            viewModel.hideError()
        }, screen = {
            HomeScreen(modifier = modifier, state = state)
        })
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier, state: HomeUiState) {
    LazyColumn(
        modifier = modifier
            .fillMaxHeight()
    ) {
        item {
            CurrentWeatherWidget(
                modifier = Modifier,
                state = state.weatherUi
            )
            HorizontalDivider(thickness = 1.dp)
            OtherConditionsSection(
                modifier = Modifier.padding(8.dp),
                state = state.weatherCondition
            )

            HorizontalDivider(thickness = 1.dp)
            Subtitle(
                text = stringResource(id = R.string.home_weekly_forecast_title)
            )
        }
        items(items = state.forecast) { forecastItem ->
            ForecastItem(
                forecast = forecastItem
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(state = HomeUiState())
}