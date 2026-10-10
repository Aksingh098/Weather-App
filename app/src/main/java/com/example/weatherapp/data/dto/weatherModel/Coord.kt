package com.example.weatherapp.data.dto.weatherModel

import kotlinx.serialization.Serializable

@Serializable
data class Coord(
    val lat: Double,
    val lon: Double
)