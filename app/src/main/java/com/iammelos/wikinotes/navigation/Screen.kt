package com.iammelos.wikinotes.navigation

import com.iammelos.wikinotes.core.Constants.AUTH_SCREEN
import com.iammelos.wikinotes.core.Constants.PROFILE_SCREEN
import com.iammelos.wikinotes.core.Constants.VOLUME_SEARCH_SCREEN

sealed class Screen(val route: String) {
    object AuthScreen: Screen(AUTH_SCREEN)
    object ProfileScreen: Screen(PROFILE_SCREEN)
    object VolumeSearchScreen: Screen(VOLUME_SEARCH_SCREEN)
}
