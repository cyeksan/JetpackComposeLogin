package com.example.jetpackcomposelogin

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposelogin.composables.*

import com.example.jetpackcomposelogin.ui.theme.JetpackComposeLoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        setContent {
            JetpackComposeLoginTheme {
                LoginApplication()
            }
        }
    }




    @Composable
    fun LoginApplication() {

        //LoginPage("login_page")
        val navController = rememberNavController()
        val navBarNavController = rememberNavController()

        NavHost(navController = navController, startDestination = Screen.LoginPage.route) {
            composable(
                route = Screen.LoginPage.route,
                content = { LoginPage(navController = navController) })
            composable(
                route = Screen.RegisterPage.route,
                content = { RegisterPage(navController = navController) })
            composable(
                route = Screen.AppScaffold.route,
                content = { AppScaffold(navController = navBarNavController) })

        }

    }
}



