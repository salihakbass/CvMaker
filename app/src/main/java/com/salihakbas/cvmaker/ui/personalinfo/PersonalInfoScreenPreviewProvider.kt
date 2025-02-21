package com.salihakbas.cvmaker.ui.personalinfo

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class PersonalInfoScreenPreviewProvider : PreviewParameterProvider<PersonalInfoContract.UiState> {
    override val values: Sequence<PersonalInfoContract.UiState>
        get() = sequenceOf(
            PersonalInfoContract.UiState(
                isLoading = true,
                list = emptyList(),
            ),
            PersonalInfoContract.UiState(
                isLoading = false,
                list = emptyList(),
            ),
            PersonalInfoContract.UiState(
                isLoading = false,
                list = listOf("Item 1", "Item 2", "Item 3")
            ),
        )
}