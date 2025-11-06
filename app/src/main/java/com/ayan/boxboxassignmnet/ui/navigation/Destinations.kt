package com.ayan.boxboxassignmnet.ui.navigation

sealed class Destinations(val route: String) {
    data object Home : Destinations("home")
    data object Details : Destinations("details")
}