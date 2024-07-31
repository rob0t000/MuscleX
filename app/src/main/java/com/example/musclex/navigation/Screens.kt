package com.example.musclex.navigation


sealed class Screens(val route: String) {
    data object Login : Screens("login")
    data object Splash : Screens("Splash")
    data object Home: Screens("Home")
    data object Exercise: Screens("Exercise")


}