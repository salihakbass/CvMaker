package com.salihakbas.cvmaker.ui.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class PreviewScreenPreviewProvider : PreviewParameterProvider<PreviewContract.UiState> {
    override val values: Sequence<PreviewContract.UiState>
        get() = sequenceOf(
            PreviewContract.UiState(
                isLoading = true,
                list = emptyList(),
            ),
            PreviewContract.UiState(
                isLoading = false,
                list = emptyList(),
            ),
            PreviewContract.UiState(
                isLoading = false,
                list = listOf("Item 1", "Item 2", "Item 3")
            ),
        )
}