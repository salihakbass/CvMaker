package com.salihakbas.cvmaker.ui.referenceinfo

object ReferenceInfoContract {
    data class UiState(
        val isLoading: Boolean = false,
        val list: List<String> = emptyList(),
    )

    sealed class UiAction

    sealed class UiEffect
}