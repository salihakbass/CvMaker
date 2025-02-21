package com.salihakbas.cvmaker.ui.skillsinfo

object SkillsInfoContract {
    data class UiState(
        val isLoading: Boolean = false,
        val list: List<String> = emptyList(),
    )

    sealed class UiAction

    sealed class UiEffect
}