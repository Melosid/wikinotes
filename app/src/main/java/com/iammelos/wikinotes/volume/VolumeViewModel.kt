package com.iammelos.wikinotes.volume

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iammelos.wikinotes.data.VolumeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class VolumeUiState(
    val id: String = "",
    val title: String = "",
    val description: String = "",
)

@HiltViewModel
class VolumeViewModel @Inject constructor(
    private val defaultVolumeRepository: VolumeRepository,
) : ViewModel() {
    init {
        loadVolume("_7m0uQAACAAJ")
    }

    private val _uiState = MutableStateFlow(VolumeUiState())
    val uiState: StateFlow<VolumeUiState> = _uiState.asStateFlow()

    private fun loadVolume(volumeId: String) {
        viewModelScope.launch {
            defaultVolumeRepository.getVolume(volumeId, true).let { volume ->
                println(volume)
                _uiState.update {
                    it.copy(
                        id = volume?.id ?: "",
                        title = volume?.title ?: "",
                        description = volume?.description ?: ""
                    )
                }
            }
        }
    }
}