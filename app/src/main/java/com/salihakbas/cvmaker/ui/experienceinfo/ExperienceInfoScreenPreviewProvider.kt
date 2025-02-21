package com.salihakbas.cvmaker.ui.experienceinfo

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class ExperienceInfoScreenPreviewProvider :
    PreviewParameterProvider<ExperienceInfoContract.UiState> {
    override val values: Sequence<ExperienceInfoContract.UiState>
        get() = sequenceOf(
            ExperienceInfoContract.UiState(
                isLoading = true,
                list = emptyList(),
            ),
            ExperienceInfoContract.UiState(
                isLoading = false,
                list = emptyList(),
            ),
            ExperienceInfoContract.UiState(
                isLoading = false,
                list = listOf("Item 1", "Item 2", "Item 3")
            ),
        )
}