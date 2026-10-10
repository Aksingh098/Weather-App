package com.example.weatherapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.WeatherRepository
import com.example.weatherapp.data.dto.weatherModel.WeatherResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel(private val repository: WeatherRepository = WeatherRepository()): ViewModel() {

    private val _uiState = MutableStateFlow<WeatherUiState>(WeatherUiState.Loading)
    val uiState: StateFlow<WeatherUiState> = _uiState.asStateFlow()

    private val _searchedQuery = MutableStateFlow("Delhi")
    val searchedQuery = _searchedQuery.asStateFlow()

    fun loadWeather(city: String){
        viewModelScope.launch {

            _uiState.value = WeatherUiState.Loading

            val weatherData = repository.getWeatherDetails(city)

            weatherData.fold(
                onSuccess = {weather->
                    val forecastData = repository.getForecast(city)

                    forecastData.fold(
                        onSuccess = {forecasts->
                            _uiState.value = WeatherUiState.Success(
                                currentWeather = weather,
                                weatherForecast = forecasts.list.take(8)
                            )

                        },
                        onFailure = {
                            _uiState.value = WeatherUiState.Success(
                                currentWeather = weather,
                                weatherForecast = emptyList()
                            )

                        }
                    )

                },
                onFailure = {error->
                    _uiState.value = WeatherUiState.Error(
                        errorMessage = error.message ?: "Failed to load Weather"
                    )

                }
            )



        }
    }

    fun updateSearchedQuery(query:String){
        _searchedQuery.value = query
    }

    fun refreshScreen(){
        loadWeather(_searchedQuery.value)
    }

    override fun onCleared() {
        super.onCleared()
        repository.close()

    }
}