package com.pdmcourse2026.basictemplate.screens.results

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pdmcourse2026.basictemplate.data.repositories.VotingApiRepository
import com.pdmcourse2026.basictemplate.data.repositories.VotingRepository
import com.pdmcourse2026.basictemplate.model.Option
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ResultsViewModel : ViewModel() {
    private val votingRepository: VotingRepository = VotingApiRepository()

    private val _options = MutableStateFlow<List<Option>>(emptyList())
    val options = _options.asStateFlow()

    private val _loading = MutableStateFlow<Boolean>(false)
    val loading = _loading.asStateFlow()

    private val _refreshing = MutableStateFlow<Boolean>(false)
    val refreshing = _refreshing.asStateFlow()

    private val _saving = MutableStateFlow<Boolean>(false)
    val saving = _saving.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error = _error.asStateFlow()

    private val _saveMessage = MutableStateFlow<String?>(null)
    val saveMessage = _saveMessage.asStateFlow()

    fun loadOptions() {
        viewModelScope.launch {
            _error.value = null
            _loading.value = true

            votingRepository.getOptions()
                .onSuccess { options ->
                    _options.value = options
                }
                .onFailure {
                    _error.value = "Error al cargar"
                }
            _loading.value = false
        }
    }

    fun refreshVotes() {
        viewModelScope.launch {
            _error.value = null
            _refreshing.value = true

            votingRepository.getOptions()
                .onSuccess { options ->
                    _options.value = options
                }
                .onFailure {
                    _error.value = "Error al cargar"
                }
            _refreshing.value = false
        }
    }


}