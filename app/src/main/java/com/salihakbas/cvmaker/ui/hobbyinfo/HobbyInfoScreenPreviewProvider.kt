package com.salihakbas.cvmaker.ui.hobbyinfo

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class HobbyInfoScreenPreviewProvider : PreviewParameterProvider<HobbyInfoContract.UiState> {
    override val values: Sequence<HobbyInfoContract.UiState>
        get() = sequenceOf(
            HobbyInfoContract.UiState(
                isLoading = true,
                list = emptyList(),
            ),
            HobbyInfoContract.UiState(
                isLoading = false,
                list = emptyList(),
            ),
            HobbyInfoContract.UiState(
                isLoading = false,
                list = listOf("Item 1", "Item 2", "Item 3")
            ),
        )
}