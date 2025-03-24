package com.example.navegacio.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Screen3(userName: String, salutacio: String, edat: Float, navigationBack: () -> Unit) {
    var showText: Boolean by remember { mutableStateOf(false) }
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            showText = true
        }) {
            Text("Show")
        }
        if(showText){
            val frase = crearFrase(userName, salutacio, edat)
            Text(frase)
            Button(onClick = {
                navigationBack()
            }) {
                Text("Return to Pantalla 1")
            }
        }

    }
}

private fun crearFrase(userName: String, salutacio: String, edat: Float): String {
    var frase = ""
    if(salutacio == "Hola"){
        frase = "Hola $userName, com portes aquests $edat anys?"
    }
    else{
        frase = "Espero tornar a veure’t $userName, abans que facis ${edat+1} anys"
    }
    return frase
}
