package com.salihakbas.cvmaker.ui.skillsinfo

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class SkillsInfoScreenPreviewProvider : PreviewParameterProvider<SkillsInfoContract.UiState> {
    override val values: Sequence<SkillsInfoContract.UiState>
        get() = sequenceOf(
            SkillsInfoContract.UiState(
                isLoading = true,
                list = emptyList(),
            ),
            SkillsInfoContract.UiState(
                isLoading = false,
                list = emptyList(),
            ),
            SkillsInfoContract.UiState(
                isLoading = false,
                list = listOf("Item 1", "Item 2", "Item 3")
            ),
        )
}