package com.example.navegacio.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun Screen2(userName: String, navigateToNext: (String, String, Float) -> Unit) {
    var selectedOption by remember { mutableStateOf("Hola") }
    var sliderValue by remember { mutableFloatStateOf(18f) }
    Column(
        Modifier.fillMaxSize()
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center, modifier = Modifier.weight(9f)){
            Row(modifier = Modifier.fillMaxWidth()){
                RadioButton(selected = selectedOption == "Hola",
                    onClick = { selectedOption = "Hola" })
                Text(text = "Hola", Modifier.align(CenterVertically))
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                RadioButton(selected = selectedOption == "Adéu",
                    onClick = { selectedOption = "Adéu" })
                Text(text = "Adéu", Modifier.align(CenterVertically))
            }
            Slider(
                value = sliderValue,
                onValueChange = { sliderValue = it.roundToInt().toFloat() },
                valueRange = 0f..120f,
                steps = 121
            )
            Text(text = sliderValue.toString())

            Spacer(Modifier.padding(40.dp))

            Button(onClick = { navigateToNext(userName, selectedOption, sliderValue) } ) {
                Text("NEXT STEP")
            }
        }

    }
}