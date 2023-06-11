package com.iammelos.wikinotes.data.source

import com.iammelos.wikinotes.data.source.local.LocalVolume
import com.iammelos.wikinotes.network.NetworkVolume

fun LocalVolume.toExternal() = Volume(
    id = id,
    title = title,
    description = description,
)

fun NetworkVolume.toLocal() = LocalVolume(
    id = id,
    title = volumeInfo.title,
    description = volumeInfo.description,
)
