package com.example.weatherapp.ui.weatherScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherapp.data.dto.forecastModel.ForecastItem
import com.example.weatherapp.data.dto.weatherModel.Clouds
import com.example.weatherapp.data.dto.weatherModel.Coord
import com.example.weatherapp.data.dto.weatherModel.Main
import com.example.weatherapp.data.dto.weatherModel.Sys
import com.example.weatherapp.data.dto.weatherModel.Weather
import com.example.weatherapp.data.dto.weatherModel.WeatherResponse
import com.example.weatherapp.data.dto.weatherModel.Wind
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


@Composable
fun WeatherContent(
    Weather: WeatherResponse,Forecast: List<ForecastItem>, onSearchClick:() -> Unit
){

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier =  Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column() {
                Text(
                    text = Weather.name,
                    style = MaterialTheme.typography.headlineMedium
                )
                Text(
                    text = Weather.sys.country ?: "",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

            }
        }
    }


}

fun getDate():String{
    val sdf = SimpleDateFormat("EEEE,MMMM dd,yyyy", Locale.getDefault())

    return sdf.format(Date())
}

@Preview
@Composable
fun WeatherContentPreview(){

}


