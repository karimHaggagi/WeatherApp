package com.example.weatherapp

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.core.presentation.Screens
import com.example.home.presentation.HomeRoute
import com.example.search.presentation.SearchRoute

/**
 * created by Karim Haggagi Hassan Elsayed on 2/10/25
 **/
@Composable
fun WeatherNavigation(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {

    NavHost(
        modifier = modifier.statusBarsPadding(),
        navController = navHostController,
        startDestination = Screens.Home
    ) {
        composable<Screens.Home> {
            HomeRoute()
        }
        composable<Screens.Search> {
            SearchRoute()
        }
    }
}