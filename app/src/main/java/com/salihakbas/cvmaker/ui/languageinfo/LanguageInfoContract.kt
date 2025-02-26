package com.salihakbas.cvmaker.ui.languageinfo

object LanguageInfoContract {
    data class UiState(
        val isLoading: Boolean = false,
        val list: List<String> = emptyList(),
        val language: String = "",
        val level: String = ""
    )

    sealed class UiAction {
        data class LanguageChanged(val language: String) : UiAction()
        data class LevelChanged(val level: String) : UiAction()
    }

    sealed class UiEffect
}