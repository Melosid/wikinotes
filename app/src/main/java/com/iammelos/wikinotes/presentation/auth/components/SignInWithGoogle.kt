package com.iammelos.wikinotes.presentation.auth.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.iammelos.wikinotes.components.ProgressBar
import com.iammelos.wikinotes.data.Response.Failure
import com.iammelos.wikinotes.data.Response.Success
import com.iammelos.wikinotes.data.Response.Loading
import com.iammelos.wikinotes.presentation.auth.AuthViewModel
import com.iammelos.wikinotes.core.Utils.Companion.print
import timber.log.Timber

@Composable
fun SignInWithGoogle(
    viewModel: AuthViewModel = hiltViewModel(),
    navigateToHomeScreen: (signedIn: Boolean) -> Unit
){
    when(val signInWithGoogleResponse = viewModel.signInWithGoogleResponse) {
        is Loading -> ProgressBar()
        is Success -> signInWithGoogleResponse.data?.let { signedIn ->
            LaunchedEffect(signedIn) {
                navigateToHomeScreen(signedIn)
            }
        }
        is Failure -> LaunchedEffect(Unit) {
            Timber.d(signInWithGoogleResponse.e)
        }
    }
}