package com.iammelos.wikinotes

import com.google.android.gms.auth.api.identity.SignInClient
import com.iammelos.wikinotes.presentation.auth.AuthViewModel
import com.iammelos.wikinotes.testing.data.TestAuthRepository
import com.iammelos.wikinotes.testing.util.MainDispatcherRule
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.test.assertEquals
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AuthViewModelTest {

    @get:Rule
    val dispatcherRule = MainDispatcherRule()

    private val authRepository = TestAuthRepository()
    private lateinit var viewModel: AuthViewModel

    @Mock
    private lateinit var mockSignInClient: SignInClient


    @Before
    fun setup() {
        viewModel = AuthViewModel(repo = authRepository, oneTapClient = mockSignInClient)
    }

    @Test
    fun userAuthenticated_whenInitialized_thenFalse() = runTest {
        assertEquals(false, viewModel.isUserAuthenticated)
    }
}