package com.example.weatherapp.ui

import com.example.weatherapp.data.dto.forecastModel.ForecastItem
import com.example.weatherapp.data.dto.weatherModel.WeatherResponse

sealed class WeatherUiState {

    object Loading: WeatherUiState()

    data class Success(
        val currentWeather: WeatherResponse,
        val weatherForecast: List<ForecastItem> = emptyList()
    ): WeatherUiState()

    data class Error(
        val errorMessage:String
    ): WeatherUiState()
}