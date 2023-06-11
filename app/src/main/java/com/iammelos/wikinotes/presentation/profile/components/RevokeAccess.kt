package com.iammelos.wikinotes.presentation.profile.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.iammelos.wikinotes.components.ProgressBar
import com.iammelos.wikinotes.data.Response.Loading
import com.iammelos.wikinotes.data.Response.Success
import com.iammelos.wikinotes.data.Response.Failure
import com.iammelos.wikinotes.presentation.profile.ProfileViewModel
import com.iammelos.wikinotes.core.Utils.Companion.print
import timber.log.Timber

@Composable
fun RevokeAccess(
    viewModel: ProfileViewModel = hiltViewModel(),
    navigateToAuthScreen: (accessRevoked: Boolean) -> Unit,
    showSnackBar: () -> Unit
) {
    when (val revokeAccessResponse = viewModel.revokeAccessResponse) {
        is Loading -> ProgressBar()
        is Success -> revokeAccessResponse.data?.let { accessRevoked ->
            LaunchedEffect(accessRevoked) {
                navigateToAuthScreen(accessRevoked)
            }
        }
        is Failure -> LaunchedEffect(Unit) {
            Timber.d(revokeAccessResponse.e)
            showSnackBar()
        }

    }
}