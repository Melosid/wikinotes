package com.iammelos.wikinotes.core

object Constants {
    const val TAG = "AppTag"

    //User fields
    const val DISPLAY_NAME = "displayName"
    const val EMAIL = "email"
    const val PHOTO_URL = "photoUrl"
    const val CREATED_AT = "createdAt"

    //Collection References
    const val USERS = "users"

    //Names
    const val SIGN_IN_REQUEST = "signInRequest"
    const val SIGN_UP_REQUEST = "signUpRequest"

    //Buttons
    const val SIGN_IN_WITH_GOOGLE = "Sign in with Google"
    const val SIGN_OUT = "Sign-out"
    const val REVOKE_ACCESS = "Revoke Access"

    //Screens
    const val AUTH_SCREEN = "Authentication"
    const val PROFILE_SCREEN = "Profile"
    const val VOLUME_SEARCH_SCREEN = "Search Books"

    //Messages
    const val REVOKE_ACCESS_MESSAGE = "You need to re-authenticate before revoking the access."

    //Google Books API
    const val BOOKS_ENDPOINT = "https://www.googleapis.com/books/v1/"
}