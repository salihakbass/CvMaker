package com.salihakbas.cvmaker.ui.editcv

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class EditCvScreenPreviewProvider : PreviewParameterProvider<EditCvContract.UiState> {
    override val values: Sequence<EditCvContract.UiState>
        get() = sequenceOf(
            EditCvContract.UiState(
                isLoading = true,
                list = emptyList(),
            ),
            EditCvContract.UiState(
                isLoading = false,
                list = emptyList(),
            ),
            EditCvContract.UiState(
                isLoading = false,
                list = listOf("Item 1", "Item 2", "Item 3")
            ),
        )
}