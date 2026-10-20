package com.example.weatherapp.ui.weatherScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.weatherapp.data.dto.forecastModel.ForecastItem
import java.text.SimpleDateFormat
import java.util.Locale
import kotlin.math.roundToInt

@Composable
fun Forecast(
    modifier: Modifier = Modifier,
    forecastList: List<ForecastItem>

) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "24 Hour Forecast",
            color = Color.White,
            style = MaterialTheme.typography.titleMedium
        )
        LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            items(items = forecastList) { forecast ->
                ForecastCard(
                    time = getTimeFromTimestamp(forecast.dt),
                    icon = getWeatherEmoji(forecast.weather.firstOrNull()?.main ?: "Clear"),
                    temp = "${forecast.main.temp.roundToInt()}"
                )
            }
        }
    }
}


fun getTimeFromTimestamp(timeStamp: Long): String {
    val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
    return sdf.format(timeStamp * 1000)
}

@Composable
private fun ForecastCard(time: String, icon: String, temp: String) {
    Card(
        modifier = Modifier
            .width(72.dp)
            .height(120.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 8.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = time, style = MaterialTheme.typography.labelMedium)
            Text(text = icon, style = MaterialTheme.typography.titleLarge)
            Text(text = temp, style = MaterialTheme.typography.titleMedium)
        }
    }
}

fun getWeatherEmoji(main: String): String = when (main.lowercase()) {
    "clear" -> "☀️"
    "clouds" -> "☁️"
    "rain" -> "🌧️"
    "drizzle" -> "🌦️"
    "thunderstorm" -> "⛈️"
    "snow" -> "❄️"
    "mist", "fog", "haze", "smoke" -> "🌫️"
    "dust", "sand", "ash" -> "🌪️"
    "squall", "tornado" -> "🌪️"
    else -> "🌡️"
}
