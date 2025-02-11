package com.example.core.presentation

import kotlinx.serialization.Serializable

/**
 * created by Karim Haggagi Hassan Elsayed on 2/3/25
 **/
sealed class Screens {
    // Define a home route that doesn't take any arguments
    @Serializable
    data object Home : Screens()

    // Define a profile route that takes an ID
    @Serializable
    data object Search : Screens()

    @Serializable
    data object Settings : Screens()

}