package com.salihakbas.cvmaker.ui.personalinfo

import androidx.lifecycle.ViewModel
import com.salihakbas.cvmaker.ui.personalinfo.PersonalInfoContract.UiAction
import com.salihakbas.cvmaker.ui.personalinfo.PersonalInfoContract.UiEffect
import com.salihakbas.cvmaker.ui.personalinfo.PersonalInfoContract.UiState
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
class PersonalInfoViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private val _uiEffect by lazy { Channel<UiEffect>() }
    val uiEffect: Flow<UiEffect> by lazy { _uiEffect.receiveAsFlow() }

    fun onAction(uiAction: UiAction) {
        when(uiAction) {
            is UiAction.NameChanged -> updateUiState { copy(name = uiAction.name) }
            is UiAction.SurnameChanged -> updateUiState { copy(surname = uiAction.surname) }
            is UiAction.EmailChanged -> updateUiState { copy(email = uiAction.email) }
            is UiAction.PhoneNumberChanged -> updateUiState { copy(phoneNumber = uiAction.phoneNumber) }
            is UiAction.WebsiteChanged -> updateUiState { copy(website = uiAction.website) }
            is UiAction.LocationChanged -> updateUiState { copy(location = uiAction.location) }
        }
    }

    private fun updateUiState(block: UiState.() -> UiState) {
        _uiState.update(block)
    }

    private suspend fun emitUiEffect(uiEffect: UiEffect) {
        _uiEffect.send(uiEffect)
    }
}