package com.example.weatherapp.ui.weatherScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R

@Composable
fun LoadingScreen(modifier: Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            CircularProgressIndicator(
                color = Color.White,
                strokeWidth = 5.dp,
                strokeCap = StrokeCap.Square

            )
            Text(
                stringResource(R.string.loading_weather_data),
                color = Color.White,
                fontWeight = FontWeight.SemiBold

            )

        }


    }

}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LoadingScreenPreview() {
    LoadingScreen(modifier = Modifier)
}