package com.iammelos.wikinotes.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.iammelos.wikinotes.presentation.auth.AuthScreen
import com.iammelos.wikinotes.presentation.profile.ProfileScreen
import com.iammelos.wikinotes.presentation.search.VolumeSearchScreen

@Composable
@ExperimentalAnimationApi
fun NavGraph(
    navController: NavHostController
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = Screen.VolumeSearchScreen.route,
        enterTransition = { EnterTransition.None},
        exitTransition = { ExitTransition.None }
    ){
        composable(
            route = Screen.AuthScreen.route
        ) {
            AuthScreen(
                navigateToProfileScreen = {
                    navController.navigate(Screen.VolumeSearchScreen.route)
                }
            )
        }
        composable(
            route = Screen.ProfileScreen.route
        ) {
            ProfileScreen(
                navigateToAuthScreen = {
                    navController.popBackStack()
                    navController.navigate(Screen.AuthScreen.route)
                }
            )
        }
        composable(
            route = Screen.VolumeSearchScreen.route
        ) {
            VolumeSearchScreen()
        }
    }
}