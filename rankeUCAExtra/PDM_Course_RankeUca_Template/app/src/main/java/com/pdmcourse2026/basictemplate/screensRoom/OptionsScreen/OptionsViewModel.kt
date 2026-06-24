package com.pdmcourse2026.basictemplate.screensRoom.OptionsScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.pdmcourse2026.basictemplate.BasicTemplateApplication
import com.pdmcourse2026.basictemplate.data.repository.OptionRepository
import com.pdmcourse2026.basictemplate.model.Option
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY


class OptionsViewModel(
    private val optionRepository: OptionRepository,
    private val questionId: Int
) : ViewModel() {
    val options: StateFlow<List<Option>> =
        optionRepository.getOptions(questionId)
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = emptyList()
            )

    fun addOption(name: String, imageUrl: String) {
        viewModelScope.launch {
            optionRepository.addOption(name, imageUrl, questionId)
        }
    }

    fun deleteOption(option: Option) {
        viewModelScope.launch {
            optionRepository.deleteOption(option)
        }
    }

    fun editOption(option: Option, newValue: String, newImageUrl: String) {
        viewModelScope.launch {
            val editedOption = option.copy(value = newValue, imageUrl = newImageUrl)
            optionRepository.editOption(editedOption)
        }

    }

    companion object {
        fun provideFactory(questionId: Int) = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as BasicTemplateApplication
                OptionsViewModel(app.appProvider.provideOptionRepository(), questionId)
            }
        }
    }
}