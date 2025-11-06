package com.ayan.boxboxassignmnet.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ayan.boxboxassignmnet.ui.screens.details.DetailsScreen
import com.ayan.boxboxassignmnet.ui.screens.home.HomeScreen

@Composable
fun AppNavGraph(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Destinations.Home.route
    ) {
        composable(Destinations.Home.route) {
            HomeScreen(navController)
        }
        composable(Destinations.Details.route) {
            DetailsScreen(navController)
        }
    }
    
}