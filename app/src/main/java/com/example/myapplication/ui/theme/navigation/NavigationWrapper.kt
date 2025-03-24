package com.example.myapplication.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.myapplication.ui.theme.screens.Screen_Exemple1
import com.example.myapplication.ui.theme.screens.Screen_Students
import com.example.myapplication.ui.theme.screens.Screen_Students_Param
import com.example.navegacio.screens.Screen1
import com.example.navegacio.screens.Screen2
import com.example.navegacio.screens.Screen3


@Composable
fun NavigationWrapper_Exemple1(){
    val navController = rememberNavController()
    NavHost(navController, Pantalla_Exemple1) {
        composable<Pantalla_Exemple1> {
            Screen_Exemple1()
        }
    }
}


@Composable
fun NavigationWrapper_Exemple2(){
    val navController = rememberNavController()
    NavHost(navController, Pantalla_Exemple2) {
        composable<Pantalla_Exemple2> {
            Screen_Students()
        }
    }
}

@Composable
fun NavigationWrapper_Exemple2_Param(){
    val navController = rememberNavController()
    NavHost(navController, Pantalla_Exemple2_Param) {
        composable<Pantalla_Exemple2_Param> {
            Screen_Students_Param("DAM2")
        }
    }
}

@Composable
fun NavigationWrapper_3Screens(){
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