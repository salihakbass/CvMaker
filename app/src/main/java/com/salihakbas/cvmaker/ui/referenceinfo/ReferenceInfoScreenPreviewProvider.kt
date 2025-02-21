package com.salihakbas.cvmaker.ui.referenceinfo

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class ReferenceInfoScreenPreviewProvider : PreviewParameterProvider<ReferenceInfoContract.UiState> {
    override val values: Sequence<ReferenceInfoContract.UiState>
        get() = sequenceOf(
            ReferenceInfoContract.UiState(
                isLoading = true,
                list = emptyList(),
            ),
            ReferenceInfoContract.UiState(
                isLoading = false,
                list = emptyList(),
            ),
            ReferenceInfoContract.UiState(
                isLoading = false,
                list = listOf("Item 1", "Item 2", "Item 3")
            ),
        )
}