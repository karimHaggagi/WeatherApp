package com.example.search.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui.R
import com.example.model.WeatherUi
import com.example.search.presentation.component.DialogResult
import com.example.search.presentation.component.SavedItem

/**
 * created by Karim Haggagi Hassan Elsayed on 2/10/25
 **/
@Composable
fun SearchRoute(modifier: Modifier = Modifier, viewModel: SearchViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    com.example.ui.ScreenContainer(
        modifier = modifier.fillMaxSize(),
        isLoading = uiState.isLoading,
        errorDialogText = uiState.hasError,
        screen = {
            SearchScreen(
                modifier = modifier,
                state = uiState,
                onCityNameChange = viewModel::onCityNameChange,
                onSearchClicked = viewModel::onSearchIconClick,
                onSavedLocationClick = viewModel::onSavedLocationClick,
                onDismiss = viewModel::onDismiss
            )
        })
}

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    state: SearchUiState,
    onCityNameChange: (String) -> Unit = {},
    onSearchClicked: () -> Unit = {},
    onSavedLocationClick: () -> Unit = {},
    onDismiss: () -> Unit = {}
) {

    Scaffold(
        modifier = modifier.padding(16.dp),
        topBar = {
            TextField(
                value = state.cityName,
                onValueChange = onCityNameChange,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                    )
                },

                placeholder = {
                    Text(stringResource(R.string.placeholder_search))
                },
                textStyle = TextStyle(color = MaterialTheme.colorScheme.onSecondaryContainer),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                    focusedContainerColor = MaterialTheme.colorScheme.surface,
                    errorContainerColor = MaterialTheme.colorScheme.errorContainer
                ),
                modifier = modifier
                    .fillMaxWidth()
                    .heightIn(min = 56.dp),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        onSearchClicked()
                    }
                ),
                shape = RoundedCornerShape(6.dp)
            )
        }

    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            item {
                if (state.weatherUi != null) {
                    DialogResult(state = state, onDismiss = {
                        onDismiss()
                    }, onSavedLocationClick = {
                        onSavedLocationClick()
                    })
                }
            }
            items(state.savedLocations) { item ->
                SavedItem(savedLocations = item)
            }
        }
    }
}

@com.example.ui.preview.PreviewLightDarkMode
@Composable
private fun SearchScreenPreview() {
    SearchScreen(state = SearchUiState(weatherUi = WeatherUi()))
}