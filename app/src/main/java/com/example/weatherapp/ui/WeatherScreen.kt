package com.example.weatherapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun WeatherScreen(
     modifier: Modifier =  Modifier,
     viewModel: WeatherViewModel = WeatherViewModel() // for just now not a good practice as this function recomposes
){
    val uiState =  viewModel.uiState.collectAsState()
    val searchedQuery = viewModel.searchedQuery.collectAsState()
    val showSearchDialog by remember {mutableStateOf(false)}

    Box(
        modifier = Modifier.fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        Color(0xFF1565C0),
                        Color(0xFF42A5F5),
                        Color(0xFFB3E5FC)

                    )
                )
            )
    )

    when(val state = uiState){
        is WeatherUiState.Loading ->{

        }
        is WeatherUiState.Success ->{

        }
        is WeatherUiState.Error ->{

        }
    }



}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun WeatheScreenPreview(){
    WeatherScreen()
}