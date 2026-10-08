package com.example.weatherapp.data.dto.forecastModel

import kotlinx.serialization.Serializable

@Serializable
data class Wind(
    val deg: Int,
    val gust: Double,
    val speed: Double
)