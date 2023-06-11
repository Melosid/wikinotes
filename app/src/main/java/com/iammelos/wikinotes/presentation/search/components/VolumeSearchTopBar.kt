package com.iammelos.wikinotes.presentation.search.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import com.iammelos.wikinotes.core.Constants

@Composable
fun VolumeSearchTopBar() {
    TopAppBar (
        title = {
            Text(
                text = Constants.VOLUME_SEARCH_SCREEN
            )
        }
    )
}