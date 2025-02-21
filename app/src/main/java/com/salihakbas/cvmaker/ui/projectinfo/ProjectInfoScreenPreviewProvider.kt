package com.salihakbas.cvmaker.ui.projectinfo

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class ProjectInfoScreenPreviewProvider : PreviewParameterProvider<ProjectInfoContract.UiState> {
    override val values: Sequence<ProjectInfoContract.UiState>
        get() = sequenceOf(
            ProjectInfoContract.UiState(
                isLoading = true,
                list = emptyList(),
            ),
            ProjectInfoContract.UiState(
                isLoading = false,
                list = emptyList(),
            ),
            ProjectInfoContract.UiState(
                isLoading = false,
                list = listOf("Item 1", "Item 2", "Item 3")
            ),
        )
}