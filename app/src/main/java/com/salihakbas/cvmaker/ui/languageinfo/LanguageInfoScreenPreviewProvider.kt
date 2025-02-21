package com.salihakbas.cvmaker.ui.languageinfo

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class LanguageInfoScreenPreviewProvider : PreviewParameterProvider<LanguageInfoContract.UiState> {
    override val values: Sequence<LanguageInfoContract.UiState>
        get() = sequenceOf(
            LanguageInfoContract.UiState(
                isLoading = true,
                list = emptyList(),
            ),
            LanguageInfoContract.UiState(
                isLoading = false,
                list = emptyList(),
            ),
            LanguageInfoContract.UiState(
                isLoading = false,
                list = listOf("Item 1", "Item 2", "Item 3")
            ),
        )
}