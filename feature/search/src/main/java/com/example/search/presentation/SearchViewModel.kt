package com.example.search.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.model.domainmodel.WeatherModel
import com.example.common.onError
import com.example.common.onSuccess
import com.example.utils.toUiText
import com.example.data.search.SearchRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * created by Karim Haggagi Hassan Elsayed on 2/10/25
 **/
@HiltViewModel
class SearchViewModel @Inject constructor(private val searchRepo: SearchRepo) : ViewModel() {

    private val _uiState = MutableStateFlow(SearchUiState())
    val uiState: StateFlow<SearchUiState> =
        _uiState
            .onStart { getCachedList() }
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), SearchUiState())

    init {
        observeOnCityNameChanged()
    }

    private var searchJob: Job? = null
    private var searchResult: WeatherModel? = null

    private fun getWeatherByCityName(cityName: String) {
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            searchRepo.getWeatherByCityName(cityName)
                .onSuccess { result ->
                    searchResult = result
                    _uiState.update {
                        result.asSearchUiState().copy(cityName = uiState.value.cityName)
                    }
                }
                .onError { error ->
                    _uiState.update { it.copy(hasError = error.toUiText()) }
                }
        }
    }

    fun onCityNameChange(cityName: String) {
        _uiState.update { it.copy(cityName = cityName) }
    }

    fun onSearchIconClick() {
        if (searchResult != null && searchResult?.name == uiState.value.cityName) {
            _uiState.update {
                searchResult!!.asSearchUiState().copy(cityName = uiState.value.cityName)
            }
            return
        }
        getWeatherByCityName(uiState.value.cityName)
    }

    fun onSavedLocationClick() {
        viewModelScope.launch {
            searchResult?.let { searchRepo.saveLocationToDatabase(it) }
        }
    }

    fun onDismiss() {
        _uiState.update { it.copy(weatherUi = null) }
    }

    @OptIn(FlowPreview::class)
    private fun observeOnCityNameChanged() {
        uiState.map { it.cityName }
            .debounce(DEBOUNCE_TIME_MS)
            .distinctUntilChanged()
            .flowOn(Dispatchers.IO)
            .onEach {
                if (it.isNotEmpty()) {
                    getWeatherByCityName(it)
                }
            }
    }

    private fun getCachedList() {
        viewModelScope.launch {
            searchRepo.getCashedList().collect { result ->
                _uiState.update { it.copy(savedLocations = result.map { it.asSavedLocations() }) }
            }
        }
    }

    companion object {
        private const val DEBOUNCE_TIME_MS = 1000L
    }
}