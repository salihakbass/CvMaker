package com.salihakbas.cvmaker.ui.personalinfo

object PersonalInfoContract {
    data class UiState(
        val isLoading: Boolean = false,
        val list: List<String> = emptyList(),
        val name: String = "",
        val surname: String = "",
        val email: String = "",
        val phoneNumber: String = "",
        val website: String = "",
        val location: String = ""
    )

    sealed class UiAction {
        data class NameChanged(val name: String) : UiAction()
        data class SurnameChanged(val surname: String) : UiAction()
        data class EmailChanged(val email: String) : UiAction()
        data class PhoneNumberChanged(val phoneNumber: String) : UiAction()
        data class WebsiteChanged(val website: String) : UiAction()
        data class LocationChanged(val location: String) : UiAction()
    }

    sealed class UiEffect
}