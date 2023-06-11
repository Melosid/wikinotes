package com.iammelos.wikinotes.data.source.network

import com.iammelos.wikinotes.core.Constants.BOOKS_ENDPOINT
import com.iammelos.wikinotes.network.NetworkVolume
import com.iammelos.wikinotes.network.NetworkVolumeList
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.serialization.json.Json
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.http.Query

interface GoogleApiService {
    @GET("volumes/{id}")
    suspend fun loadVolume(@Path("id") id: String): NetworkVolume

    @GET("volumes")
    suspend fun searchVolume(@Query("q") query: String): NetworkVolumeList
}

@Singleton
class GoogleApiNetwork @Inject constructor(
    networkJson: Json,
    okhttpCallFactory: Call.Factory,
) : NetworkDataSource {

    // Configure retrofit to parse JSON and use coroutines
    private val retrofit = Retrofit.Builder()
        .baseUrl(BOOKS_ENDPOINT)
        .callFactory(okhttpCallFactory)
        .addConverterFactory(
            networkJson.asConverterFactory("application/json".toMediaType()),
        )
        .build()
        .create(GoogleApiService::class.java)

    override suspend fun loadVolume(volumeId: String): NetworkVolume = retrofit.loadVolume(volumeId)

    override suspend fun searchVolume(query: String): NetworkVolumeList = retrofit.searchVolume(query)
}