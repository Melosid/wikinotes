package com.iammelos.wikinotes.presentation.profile.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.iammelos.wikinotes.components.ProgressBar
import com.iammelos.wikinotes.data.Response.Success
import com.iammelos.wikinotes.data.Response.Failure
import com.iammelos.wikinotes.data.Response.Loading
import com.iammelos.wikinotes.presentation.profile.ProfileViewModel
import com.iammelos.wikinotes.core.Utils.Companion.print
import timber.log.Timber

@Composable
fun SignOut(
    viewModel: ProfileViewModel = hiltViewModel(),
    navigateToAuthScreen: (signedOut: Boolean) -> Unit
) {
    when(val signOutResponse = viewModel.signOutResponse) {
        is Loading -> ProgressBar()
        is Success -> signOutResponse.data?.let{ signedOut ->
            LaunchedEffect(signOutResponse) {
                navigateToAuthScreen(signedOut)
            }
        }
        is Failure -> LaunchedEffect(Unit) {
            Timber.d(signOutResponse.e)
        }
    }
}