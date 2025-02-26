package com.salihakbas.cvmaker.ui.languageinfo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.salihakbas.cvmaker.R
import com.salihakbas.cvmaker.ui.components.EmptyScreen
import com.salihakbas.cvmaker.ui.components.InfoTextField
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
        else -> LanguageInfoContent(
            uiState = uiState,
            onAction = onAction
        )
    }
}

@Composable
fun LanguageInfoContent(
    uiState: UiState,
    onAction: (UiAction) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            InfoTextField(
                value = uiState.language,
                onValueChange = { onAction(UiAction.LanguageChanged(it)) },
                labelText = "Dil",
                modifier = Modifier.weight(1f),
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_language),
                        contentDescription = null
                    )
                }
            )
            Spacer(modifier = Modifier.width(4.dp))
            InfoTextField(
                value = uiState.level,
                onValueChange = { onAction(UiAction.LevelChanged(it)) },
                labelText = "Seviye",
                modifier = Modifier.weight(1f),
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_language),
                        contentDescription = null
                    )
                }
            )
        }

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