package com.salihakbas.cvmaker.ui.templateselection

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class TemplateSelectionScreenPreviewProvider :
    PreviewParameterProvider<TemplateSelectionContract.UiState> {
    override val values: Sequence<TemplateSelectionContract.UiState>
        get() = sequenceOf(
            TemplateSelectionContract.UiState(
                isLoading = true,
                list = emptyList(),
            ),
            TemplateSelectionContract.UiState(
                isLoading = false,
                list = emptyList(),
            ),
            TemplateSelectionContract.UiState(
                isLoading = false,
                list = listOf("Item 1", "Item 2", "Item 3")
            ),
        )
}