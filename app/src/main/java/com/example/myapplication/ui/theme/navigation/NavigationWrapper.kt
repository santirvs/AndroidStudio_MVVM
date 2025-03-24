package com.example.myapplication.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.navegacio.screens.Screen1
import com.example.navegacio.screens.Screen2
import com.example.navegacio.screens.Screen3

@Composable
fun NavigationWrapper(){
    val navController = rememberNavController()
    NavHost(navController, Pantalla1) {
        composable<Pantalla1> {
            Screen1{ userName -> navController.navigate(Pantalla2(userName))}
        }

        composable<Pantalla2> { backStackEntry ->
            val pantalla2 = backStackEntry.toRoute<Pantalla2>()
            Screen2(pantalla2.userName) {
                userName, salutacio, edat -> navController.navigate(Pantalla3(userName, salutacio, edat))
            }
        }

        composable<Pantalla3> { backStackEntry ->
            val pantalla3 = backStackEntry.toRoute<Pantalla3>()
            Screen3(pantalla3.userName, pantalla3.salutacio, pantalla3.edat) {
                //navController.popBackStack()
                navController.navigate(Pantalla1) {
                    popUpTo<Pantalla1> { inclusive = true }
                }
            }
        }
    }
}