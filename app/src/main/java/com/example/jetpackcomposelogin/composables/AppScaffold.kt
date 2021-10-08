package com.example.jetpackcomposelogin.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

@Composable
fun AppScaffold(navController: NavController) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(

        bottomBar = {
            BottomBar(navController = navController)
        },
        scaffoldState = scaffoldState,

    ) {

        NavigationHost(navController = navController)
    }

}