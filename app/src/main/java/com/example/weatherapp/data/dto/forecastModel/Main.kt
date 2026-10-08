package com.example.weatherapp.data.dto.forecastModel

import kotlinx.serialization.Serializable

@Serializable
data class Main(
    val dew_point: Double,
    val feels_like: Double,
    val grnd_level: Int,
    val humidity: Int,
    val pressure: Int,
    val sea_level: Int,
    val temp: Double,
    val temp_kf: Double,
    val temp_max: Double,
    val temp_min: Double
)