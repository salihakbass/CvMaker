package com.salihakbas.cvmaker.ui.createcv

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class CreateCvScreenPreviewProvider : PreviewParameterProvider<CreateCvContract.UiState> {
    override val values: Sequence<CreateCvContract.UiState>
        get() = sequenceOf(
            CreateCvContract.UiState(
                isLoading = true,
                list = emptyList(),
            ),
            CreateCvContract.UiState(
                isLoading = false,
                list = emptyList(),
            ),
            CreateCvContract.UiState(
                isLoading = false,
                list = listOf("Item 1", "Item 2", "Item 3")
            ),
        )
}