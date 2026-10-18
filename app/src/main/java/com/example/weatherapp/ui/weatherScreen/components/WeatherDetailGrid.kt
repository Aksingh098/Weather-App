package com.example.weatherapp.ui.weatherScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R
import kotlin.math.roundToInt

@Composable
fun WeatherDetailGrid(
    feelsLike: Double,
    humidity: Int,
    visibility: Int,
    pressure: Int
) {

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            DetailCard(
                "🌡️",
                stringResource(R.string.feels_like),
                "${feelsLike.roundToInt()}°",
                Modifier.weight(1f)
            )
            DetailCard(
                "💧",
                stringResource(R.string.humidity),
                "${humidity}%",
                Modifier.weight(1f)
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            DetailCard(
                "👁️",
                stringResource(R.string.visibility),
                "$visibility km",
                Modifier.weight(1f)
            )
            DetailCard(
                "🧭",
                stringResource(R.string.pressure),
                "$pressure hPa",
                Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun DetailCard(
    emoji: String,
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier.background(color = Color.White.copy(0.25f))) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = emoji,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = value,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}