package com.example.myapplication.ui.theme.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.ui.theme.models.CounterViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun Body() {
    val counterViewModel = viewModel<CounterViewModel>()
    val clicksValue: Int by counterViewModel.clicksValue.observeAsState(0)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = clicksValue.toString(), fontSize = 24.sp)
        Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
            Button(onClick = { counterViewModel.onDecrementClicked() }) { Text(text = "Decrementa") }
            Button(onClick = { counterViewModel.onIncrementClicked()}) { Text(text = "Incrementa") }
        }
    }
}
