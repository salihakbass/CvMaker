package com.salihakbas.cvmaker.ui.editcv

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
import com.salihakbas.cvmaker.ui.editcv.EditCvContract.UiAction
import com.salihakbas.cvmaker.ui.editcv.EditCvContract.UiEffect
import com.salihakbas.cvmaker.ui.editcv.EditCvContract.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun EditCvScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
) {
    when {
        uiState.isLoading -> LoadingBar()
        uiState.list.isNotEmpty() -> EmptyScreen()
        else -> EditCvContent()
    }
}

@Composable
fun EditCvContent() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "EditCv Content",
            fontSize = 24.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun EditCvScreenPreview(
    @PreviewParameter(EditCvScreenPreviewProvider::class) uiState: UiState,
) {
    EditCvScreen(
        uiState = uiState,
        uiEffect = emptyFlow(),
        onAction = {},
    )
}