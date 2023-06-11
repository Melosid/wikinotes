package com.iammelos.wikinotes.data.source.network

import com.iammelos.wikinotes.network.NetworkVolume
import com.iammelos.wikinotes.network.NetworkVolumeList

interface NetworkDataSource {
    suspend fun loadVolume(volumeId: String): NetworkVolume

    suspend fun searchVolume(query: String): NetworkVolumeList
}