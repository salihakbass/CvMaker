package com.salihakbas.cvmaker.ui.educationinfo

object EducationInfoContract {
    data class UiState(
        val isLoading: Boolean = false,
        val list: List<String> = emptyList(),
    )

    sealed class UiAction

    sealed class UiEffect
}