package com.iammelos.wikinotes.data.source.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface VolumeDao {

    @Query("SELECT * FROM volume WHERE id = :volumeId")
    fun observeById(volumeId: String): Flow<LocalVolume>

    @Query("SELECT * FROM volume WHERE id = :volumeId")
    suspend fun getById(volumeId: String): LocalVolume?

    @Upsert
    suspend fun upsert(volume: LocalVolume)
}