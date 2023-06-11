package com.iammelos.wikinotes.testing.data

import com.google.firebase.auth.AuthCredential
import com.iammelos.wikinotes.data.AuthRepository
import com.iammelos.wikinotes.data.OneTapSignInResponse
import com.iammelos.wikinotes.data.SignInWithGoogleResponse

class TestAuthRepository: AuthRepository {
    override val isUserAuthenticatedInFirebase = false

    override suspend fun oneTapSignInWithGoogle(): OneTapSignInResponse {
        TODO("Not yet implemented")
    }

    override suspend fun firebaseSignInWithGoogle(googleCredential: AuthCredential): SignInWithGoogleResponse {
        TODO("Not yet implemented")
    }
}