package com.salihakbas.cvmaker.ui.experienceinfo

object ExperienceInfoContract {
    data class UiState(
        val isLoading: Boolean = false,
        val list: List<String> = emptyList(),
        val companyName: String = "",
        val position: String = "",
        val startDate: String = "",
        val endDate: String = "",
        val description: String = "",
    )

    sealed class UiAction {
        data class CompanyNameChanged(val companyName: String) : UiAction()
        data class PositionChanged(val position: String) : UiAction()
        data class StartDateChanged(val startDate: String) : UiAction()
        data class EndDateChanged(val endDate: String) : UiAction()
        data class DescriptionChanged(val description: String) : UiAction()
    }

    sealed class UiEffect
}