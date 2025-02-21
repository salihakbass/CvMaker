package com.salihakbas.cvmaker.ui.experienceinfo

object ExperienceInfoContract {
    data class UiState(
        val isLoading: Boolean = false,
        val list: List<String> = emptyList(),
    )

    sealed class UiAction

    sealed class UiEffect
}