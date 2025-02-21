package com.salihakbas.cvmaker.ui.educationinfo

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class EducationInfoScreenPreviewProvider : PreviewParameterProvider<EducationInfoContract.UiState> {
    override val values: Sequence<EducationInfoContract.UiState>
        get() = sequenceOf(
            EducationInfoContract.UiState(
                isLoading = true,
                list = emptyList(),
            ),
            EducationInfoContract.UiState(
                isLoading = false,
                list = emptyList(),
            ),
            EducationInfoContract.UiState(
                isLoading = false,
                list = listOf("Item 1", "Item 2", "Item 3")
            ),
        )
}