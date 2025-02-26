package com.salihakbas.cvmaker.ui.skillsinfo

object SkillsInfoContract {
    data class UiState(
        val isLoading: Boolean = false,
        val list: List<String> = emptyList(),
        val skills: String = ""
    )

    sealed class UiAction {
        data class SkillsChanged(val skills: String) : UiAction()
    }

    sealed class UiEffect
}