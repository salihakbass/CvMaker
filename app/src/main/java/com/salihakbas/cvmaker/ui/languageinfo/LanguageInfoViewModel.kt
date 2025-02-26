package com.salihakbas.cvmaker.ui.languageinfo

import androidx.lifecycle.ViewModel
import com.salihakbas.cvmaker.ui.languageinfo.LanguageInfoContract.UiAction
import com.salihakbas.cvmaker.ui.languageinfo.LanguageInfoContract.UiEffect
import com.salihakbas.cvmaker.ui.languageinfo.LanguageInfoContract.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LanguageInfoViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private val _uiEffect by lazy { Channel<UiEffect>() }
    val uiEffect: Flow<UiEffect> by lazy { _uiEffect.receiveAsFlow() }

    fun onAction(uiAction: UiAction) {
        when (uiAction) {
            is UiAction.LanguageChanged -> updateUiState { copy(language = uiAction.language) }
            is UiAction.LevelChanged -> updateUiState { copy(level = uiAction.level) }
        }
    }

    private fun updateUiState(block: UiState.() -> UiState) {
        _uiState.update(block)
    }

    private suspend fun emitUiEffect(uiEffect: UiEffect) {
        _uiEffect.send(uiEffect)
    }
}