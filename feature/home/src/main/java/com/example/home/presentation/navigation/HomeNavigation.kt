package com.example.home.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.core.presentation.Screens
import com.example.home.presentation.HomeRoute


fun NavGraphBuilder.homeRoute() {

    composable<Screens.Home>() {
        HomeRoute()
    }
}