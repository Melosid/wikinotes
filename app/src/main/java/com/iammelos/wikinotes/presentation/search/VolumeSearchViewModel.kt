package com.iammelos.wikinotes.presentation.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.iammelos.wikinotes.data.VolumeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.iammelos.wikinotes.data.source.local.LocalVolume
import kotlinx.coroutines.launch

@HiltViewModel
class VolumeSearchViewModel @Inject constructor(
    private val defaultVolumeRepository: VolumeRepository,
) : ViewModel() {
    var suggestions by mutableStateOf(arrayOf<LocalVolume>())
        private set

    fun search(query: String) = viewModelScope.launch {
        suggestions = defaultVolumeRepository.searchVolume(query).items
    }
}