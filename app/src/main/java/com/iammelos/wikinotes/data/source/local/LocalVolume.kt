package com.iammelos.wikinotes.data.source.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(
    tableName = "volume"
)
data class LocalVolume(
    @PrimaryKey val id: String = "",
    var title: String = "",
    var description: String? = "",
)


@Serializable
data class LocalVolumeList(
    val items: Array<LocalVolume>
)
