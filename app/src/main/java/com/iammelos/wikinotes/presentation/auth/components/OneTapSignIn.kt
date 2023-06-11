package com.iammelos.wikinotes.presentation.auth.components

import android.widget.ProgressBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.android.gms.auth.api.identity.BeginSignInResult
import com.iammelos.wikinotes.data.Response.Loading
import com.iammelos.wikinotes.data.Response.Success
import com.iammelos.wikinotes.data.Response.Failure
import com.iammelos.wikinotes.presentation.auth.AuthViewModel
import com.iammelos.wikinotes.components.ProgressBar
import com.iammelos.wikinotes.core.Utils.Companion.print
import timber.log.Timber

@Composable
fun OneTapSignIn(
    viewModel: AuthViewModel = hiltViewModel(),
    launch: (result: BeginSignInResult) -> Unit
) {
    when(val oneTapSignInResponse = viewModel.oneTapSignInResponse) {
        is Loading -> ProgressBar()
        is Success -> oneTapSignInResponse.data?.let {
            LaunchedEffect(it) {
                launch(it)
            }
        }
        is Failure -> LaunchedEffect(Unit) {
            Timber.d(oneTapSignInResponse.e)
        }
    }
}