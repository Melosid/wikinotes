package com.iammelos.wikinotes.presentation.profile.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.iammelos.wikinotes.core.Constants.PROFILE_SCREEN
import com.iammelos.wikinotes.core.Constants.REVOKE_ACCESS
import com.iammelos.wikinotes.core.Constants.SIGN_OUT

@Preview
@Composable
fun ProfileTopBar(
    signOut: () -> Unit,
    revokeAccess: () -> Unit
) {
    var openMenu by remember { mutableStateOf(false) }

    TopAppBar(
        title = {
            Text(
                text = PROFILE_SCREEN
            )
        },
        actions = {
            IconButton(
                onClick = {
                    openMenu = !openMenu
                }
            ) {
                Icon(
                    imageVector = Icons.Outlined.MoreVert,
                    contentDescription = null
                )
            }
            DropdownMenu(
                expanded = openMenu,
                onDismissRequest = {
                    openMenu = !openMenu
                }
            ) {
                DropdownMenuItem(
                    onClick = {
                        signOut()
                        openMenu = !openMenu
                    }
                ) {
                    Text(
                        text = SIGN_OUT
                    )
                }
                DropdownMenuItem(
                    onClick = {
                        revokeAccess()
                        openMenu = !openMenu
                    }
                ) {
                    Text(
                        text = REVOKE_ACCESS
                    )
                }
            }
        }
    )
}