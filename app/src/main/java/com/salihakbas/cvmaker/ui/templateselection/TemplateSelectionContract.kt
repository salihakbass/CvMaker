package com.salihakbas.cvmaker.ui.templateselection

object TemplateSelectionContract {
    data class UiState(
        val isLoading: Boolean = false,
        val list: List<String> = emptyList(),
    )

    sealed class UiAction

    sealed class UiEffect
}