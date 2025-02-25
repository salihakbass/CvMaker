package com.salihakbas.cvmaker.ui.educationinfo

object EducationInfoContract {
    data class UiState(
        val isLoading: Boolean = false,
        val list: List<String> = emptyList(),
        val universityName: String = "",
        val department: String = "",
        val startDate: String = "",
        val endDate: String = "",
    )

    sealed class UiAction {
        data class UniversityNameChanged(val universityName: String) : UiAction()
        data class DepartmentChanged(val department: String) : UiAction()
        data class StartDateChanged(val startDate: String) : UiAction()
        data class EndDateChanged(val endDate: String) : UiAction()
    }

    sealed class UiEffect
}