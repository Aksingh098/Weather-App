package com.example.weatherapp.data

import com.example.weatherapp.BuildConfig
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class WeatherRepository {

    private val client = HttpClient(CIO) {
        install(ContentNegotiation){
            json(Json {
                ignoreUnknownKeys = true
                isLenient = true
                prettyPrint = true
            })
        }
        install(Logging){
            logger = Logger.DEFAULT
            level = LogLevel.INFO

        }

    }

    private val apiKey = BuildConfig.MY_API_KEY


}