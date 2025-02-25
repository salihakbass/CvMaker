package com.salihakbas.cvmaker.ui.experienceinfo

import androidx.lifecycle.ViewModel
import com.salihakbas.cvmaker.ui.experienceinfo.ExperienceInfoContract.UiAction
import com.salihakbas.cvmaker.ui.experienceinfo.ExperienceInfoContract.UiEffect
import com.salihakbas.cvmaker.ui.experienceinfo.ExperienceInfoContract.UiState
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
class ExperienceInfoViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private val _uiEffect by lazy { Channel<UiEffect>() }
    val uiEffect: Flow<UiEffect> by lazy { _uiEffect.receiveAsFlow() }

    fun onAction(uiAction: UiAction) {
        when (uiAction) {
            is UiAction.CompanyNameChanged -> updateUiState { copy(companyName = uiAction.companyName) }
            is UiAction.PositionChanged -> updateUiState { copy(position = uiAction.position) }
            is UiAction.StartDateChanged -> updateUiState { copy(startDate = uiAction.startDate) }
            is UiAction.EndDateChanged -> updateUiState { copy(endDate = uiAction.endDate) }
            is UiAction.DescriptionChanged -> updateUiState { copy(description = uiAction.description) }
        }
    }

    private fun updateUiState(block: UiState.() -> UiState) {
        _uiState.update(block)
    }

    private suspend fun emitUiEffect(uiEffect: UiEffect) {
        _uiEffect.send(uiEffect)
    }
}