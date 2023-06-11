package com.iammelos.wikinotes.data

import com.iammelos.wikinotes.data.source.Volume
import com.iammelos.wikinotes.data.source.local.LocalVolumeList
import com.iammelos.wikinotes.network.NetworkVolumeList
import kotlinx.coroutines.flow.Flow

interface VolumeRepository {
    fun getVolumeStream(volumeId: String): Flow<Volume?>

    suspend fun getVolume(volumeId: String, forceUpdate: Boolean = false): Volume?

    suspend fun loadVolume(volumeId: String)

    suspend fun searchVolume(query: String): LocalVolumeList
}