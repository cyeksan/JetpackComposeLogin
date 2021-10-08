package com.example.jetpackcomposelogin.composables

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationHost(navController: NavController) {
    NavHost(

        navController = navController as NavHostController,
        startDestination = NavigationScreen.HomePage.route
    ) {
        composable(NavigationScreen.HomePage.route) { HomePage() }
        composable(NavigationScreen.SearchPage.route) { SearchPage() }
        composable(NavigationScreen.ProfilePage.route) { ProfilePage() }
    }
}