package com.example.jetpackcomposelogin.composables

import androidx.annotation.DrawableRes
import com.example.jetpackcomposelogin.R

sealed class NavigationScreen(val route: String, val title : String, @DrawableRes val icon : Int) {
    object HomePage : NavigationScreen(route = "home_page", title = "Home", icon= R.drawable.ic_home)
    object SearchPage : NavigationScreen( route = "search_page", title = "Search", icon= R.drawable.ic_search)
    object ProfilePage : NavigationScreen(route = "profile_page", title = "Profile", icon= R.drawable.ic_profile)
}