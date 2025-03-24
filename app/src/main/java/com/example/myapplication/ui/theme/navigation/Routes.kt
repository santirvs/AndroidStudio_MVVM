package com.example.myapplication.ui.theme.navigation

import kotlinx.serialization.Serializable

@Serializable
object Pantalla1

@Serializable
data class Pantalla2(val userName: String)

@Serializable
data class Pantalla3(val userName: String, val salutacio: String, val edat: Float)

@Serializable
object Pantalla_Exemple1

@Serializable
object Pantalla_Exemple2

@Serializable
object Pantalla_Exemple2_Param