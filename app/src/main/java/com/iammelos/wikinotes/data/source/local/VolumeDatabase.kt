package com.iammelos.wikinotes.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [LocalVolume::class], version = 1, exportSchema = false)
abstract class VolumeDatabase : RoomDatabase() {

    abstract fun volumeDao(): VolumeDao
}