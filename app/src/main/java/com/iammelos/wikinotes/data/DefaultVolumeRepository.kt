package com.iammelos.wikinotes.data

import com.iammelos.wikinotes.data.source.Volume
import com.iammelos.wikinotes.data.source.local.LocalVolume
import com.iammelos.wikinotes.data.source.local.LocalVolumeList
import com.iammelos.wikinotes.data.source.local.VolumeDao
import com.iammelos.wikinotes.data.source.network.GoogleApiNetwork
import com.iammelos.wikinotes.data.source.network.NetworkDataSource
import com.iammelos.wikinotes.data.source.toExternal
import com.iammelos.wikinotes.data.source.toLocal
import com.iammelos.wikinotes.di.ApplicationScope
import com.iammelos.wikinotes.di.DefaultDispatcher
import com.iammelos.wikinotes.network.NetworkVolumeList
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultVolumeRepository @Inject constructor(
    private val networkDataSource: NetworkDataSource,
    private val localDataSource: VolumeDao,
    @DefaultDispatcher private val dispatcher: CoroutineDispatcher,
    @ApplicationScope private val scope: CoroutineScope,
) : VolumeRepository {

    override fun getVolumeStream(volumeId: String): Flow<Volume?> {
        return localDataSource.observeById(volumeId).map { it.toExternal() }
    }

    override suspend fun loadVolume(volumeId: String) {
        withContext(dispatcher) {
            val remoteVolume = networkDataSource.loadVolume(volumeId)
            localDataSource.upsert(remoteVolume.toLocal())
        }
    }

    override suspend fun getVolume(volumeId: String, forceUpdate: Boolean): Volume? {
        if (forceUpdate) {
            loadVolume(volumeId)
        }
        return localDataSource.getById(volumeId)?.toExternal()
    }

    override suspend fun searchVolume(query: String): LocalVolumeList {
        return LocalVolumeList(items = networkDataSource.searchVolume(query).items.map { it.toLocal() }
            .toTypedArray())
    }
}