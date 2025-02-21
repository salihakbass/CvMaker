package com.salihakbas.cvmaker.ui.languageinfo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.sp
import com.salihakbas.cvmaker.ui.components.EmptyScreen
import com.salihakbas.cvmaker.ui.components.LoadingBar
import com.salihakbas.cvmaker.ui.languageinfo.LanguageInfoContract.UiAction
import com.salihakbas.cvmaker.ui.languageinfo.LanguageInfoContract.UiEffect
import com.salihakbas.cvmaker.ui.languageinfo.LanguageInfoContract.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun LanguageInfoScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
) {
    when {
        uiState.isLoading -> LoadingBar()
        uiState.list.isNotEmpty() -> EmptyScreen()
        else -> LanguageInfoContent()
    }
}

@Composable
fun LanguageInfoContent() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "LanguageInfo Content",
            fontSize = 24.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LanguageInfoScreenPreview(
    @PreviewParameter(LanguageInfoScreenPreviewProvider::class) uiState: UiState,
) {
    LanguageInfoScreen(
        uiState = uiState,
        uiEffect = emptyFlow(),
        onAction = {},
    )
}