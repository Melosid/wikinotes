package com.iammelos.wikinotes.data.source.network


import okhttp3.Interceptor
import okhttp3.Response
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultAuthInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val oauthToken = "oauthToken"
        request.newBuilder()
            .header("Authorization", "Oauth  $oauthToken")
            .build()
        return chain.proceed(request)
    }
}