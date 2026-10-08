package com.example.weatherapp.data.dto.forecastModel

import kotlinx.serialization.Serializable

@Serializable
data class ForecastResponse(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<Item0>,
    val message: Int
)