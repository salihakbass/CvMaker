package com.salihakbas.cvmaker.ui.createcv

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
import com.salihakbas.cvmaker.ui.createcv.CreateCvContract.UiAction
import com.salihakbas.cvmaker.ui.createcv.CreateCvContract.UiEffect
import com.salihakbas.cvmaker.ui.createcv.CreateCvContract.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun CreateCvScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
) {
    when {
        uiState.isLoading -> LoadingBar()
        uiState.list.isNotEmpty() -> EmptyScreen()
        else -> CreateCvContent()
    }
}

@Composable
fun CreateCvContent() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "CreateCv Content",
            fontSize = 24.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CreateCvScreenPreview(
    @PreviewParameter(CreateCvScreenPreviewProvider::class) uiState: UiState,
) {
    CreateCvScreen(
        uiState = uiState,
        uiEffect = emptyFlow(),
        onAction = {},
    )
}