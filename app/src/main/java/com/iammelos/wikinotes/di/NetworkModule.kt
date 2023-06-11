package com.iammelos.wikinotes.di

import com.iammelos.wikinotes.BuildConfig
import com.iammelos.wikinotes.data.source.network.DefaultAuthInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesNetworkJson(): Json = Json {
        ignoreUnknownKeys = true
    }


    @Singleton
    @Provides
    fun provideDefaultAuthInterceptor(): DefaultAuthInterceptor = DefaultAuthInterceptor()

    @Provides
    @Singleton
    fun okHttpCallFactory(
        defaultAuthInterceptor: DefaultAuthInterceptor
    ): Call.Factory = OkHttpClient.Builder()
//        .addInterceptor(defaultAuthInterceptor)
        .addInterceptor(
            HttpLoggingInterceptor()
                .apply {
                    if (BuildConfig.DEBUG) {
                        setLevel(HttpLoggingInterceptor.Level.BODY)
                    }
                },
        )
        .build()
}
