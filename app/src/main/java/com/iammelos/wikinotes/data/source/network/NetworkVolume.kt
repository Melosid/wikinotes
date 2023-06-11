package com.iammelos.wikinotes.network

import kotlinx.serialization.Serializable


@Serializable
data class NetworkVolume(
    val id: String,
    val selfLink: String,
    val volumeInfo: VolumeInfo
)

@Serializable
data class VolumeInfo(
    val title: String = "",
    val description: String = ""
)

@Serializable
data class NetworkVolumeList(
    val items: Array<NetworkVolume>
)