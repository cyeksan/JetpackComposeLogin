package com.example.jetpackcomposelogin.composables

sealed class Screen(val route: String) {
    object LoginPage: Screen("login_page")
    object RegisterPage: Screen("register_page")
    object BottomBar: Screen("bottom_bar")
    object AppScaffold: Screen("app_scaffold")


}