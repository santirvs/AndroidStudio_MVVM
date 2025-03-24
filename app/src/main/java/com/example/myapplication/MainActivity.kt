package com.example.myapplication


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.navigation.NavigationWrapper
import kotlin.time.TimeSource.Monotonic.markNow


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Mostra l'splash i el manté durant 3000 milisegons
        val splash = installSplashScreen()
        val now = markNow()
        splash.setKeepOnScreenCondition { now.elapsedNow().inWholeMilliseconds < 3000 }

        //Mostra el navigation
        setContent {
            MyApplicationTheme {
                NavigationWrapper()
            }
        }
    }
}
