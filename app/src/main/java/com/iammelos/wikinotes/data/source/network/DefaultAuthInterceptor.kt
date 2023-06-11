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
        val oauthToken =
            "eyJhbGciOiJSUzI1NiIsImtpZCI6Ijg1YmE5MzEzZmQ3YTdkNGFmYTg0ODg0YWJjYzg0MDMwMDQzNjMxODAiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL2FjY291bnRzLmdvb2dsZS5jb20iLCJhenAiOiI3ODI4NzgwOTYxNDAtZzZoZzZxaW41cXU0a2s5bGQycWx1YWV1ZjE0aTYzcTQuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJhdWQiOiI3ODI4NzgwOTYxNDAtaHY4bmtjaGFlNXRqbWczbjNjMzExN2lwOGRuN2YwNWcuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJzdWIiOiIxMDYxNzI5MDA1MjI1NTI5Mzk5MDUiLCJlbWFpbCI6ImlhbW1lbG9zZGF1dGlAZ21haWwuY29tIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsIm5hbWUiOiJNZWxvcyBEYXV0aSIsInBpY3R1cmUiOiJodHRwczovL2xoMy5nb29nbGV1c2VyY29udGVudC5jb20vYS9BQWNIVHRjUjIwb3piNWZiMjN4T0QzT29JbnlhR3lGZXl6dFoyZGsyQ1h0TD1zOTYtYyIsImdpdmVuX25hbWUiOiJNZWxvcyIsImZhbWlseV9uYW1lIjoiRGF1dGkiLCJsb2NhbGUiOiJlbiIsImlhdCI6MTY4NjI1NjY4MiwiZXhwIjoxNjg2MjYwMjgyfQ.Bhqs85j4dgh41lE-1cjaAPEBkTfYrQjA77lezS8JEhATUQpyjm3_do9ZdHTpi-tW6vRv6p-DimSoimDA1_EUcb3HFW1aK6OLdRTebquM3PU9m_DoTXJiJtvhLa7JXAwXCq5ZW7_I8LKGaTpc9RRzw7ZilZRwlYnu32CjKILioqR9sx_4OrJCaXkoMHrm49XPZCnK3inxhPRR6HMrZP6x-qiRaIb6a3oTmF192US-EFe2Ci_U3i6Kj-vEtwuJld2uhUKkWkslp0Wtqa1jdlpTeV-8FmsgkEZS5CiJtEtZOd3B0vXOsLnoLKakr6DfbnECDwLhI2FjeX8db7G36y0xBg"
        request.newBuilder()
            .header("Authorization", "Oauth  $oauthToken")
            .build()
        return chain.proceed(request)
    }
}