package com.iammelos.wikinotes.data.source.network

import com.iammelos.wikinotes.network.NetworkVolume
import com.iammelos.wikinotes.network.NetworkVolumeList
import com.iammelos.wikinotes.network.VolumeInfo
import kotlinx.coroutines.delay
import javax.inject.Inject

class VolumeNetworkDataSource @Inject constructor(
    private val network: GoogleApiNetwork
) : NetworkDataSource {
    override suspend fun loadVolume(volumeId: String): NetworkVolume {
        return network.loadVolume(volumeId)
    }

    override suspend fun searchVolume(query: String): NetworkVolumeList {
        return network.searchVolume(query)
    }
}
