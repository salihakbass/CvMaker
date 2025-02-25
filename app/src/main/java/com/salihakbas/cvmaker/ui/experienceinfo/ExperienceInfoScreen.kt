package com.salihakbas.cvmaker.ui.experienceinfo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import com.salihakbas.cvmaker.ui.experienceinfo.ExperienceInfoContract.UiAction
import com.salihakbas.cvmaker.ui.experienceinfo.ExperienceInfoContract.UiEffect
import com.salihakbas.cvmaker.ui.experienceinfo.ExperienceInfoContract.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun ExperienceInfoScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
) {
    when {
        uiState.isLoading -> LoadingBar()
        uiState.list.isNotEmpty() -> EmptyScreen()
        else -> ExperienceInfoContent(
            uiState = uiState,
            onAction = onAction
        )
    }
}

@Composable
fun ExperienceInfoContent(
    uiState: UiState,
    onAction: (UiAction) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        InfoTextField(
            value = uiState.companyName,
            onValueChange = { onAction(UiAction.CompanyNameChanged(it)) },
            labelText = "Firma Adı",
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_experience),
                    contentDescription = null
                )
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        InfoTextField(
            value = uiState.position,
            onValueChange = { onAction(UiAction.PositionChanged(it)) },
            labelText = "Pozisyon",
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_experience),
                    contentDescription = null
                )
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            InfoTextField(
                value = uiState.startDate,
                onValueChange = { onAction(UiAction.StartDateChanged(it)) },
                labelText = "Başlangıç Tarihi",
                modifier = Modifier.weight(1f),
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_calendar),
                        contentDescription = null
                    )
                }
            )
            InfoTextField(
                value = uiState.endDate,
                onValueChange = { onAction(UiAction.EndDateChanged(it)) },
                labelText = "Bitiş Tarihi",
                modifier = Modifier.weight(1f),
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_calendar),
                        contentDescription = null
                    )
                }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = uiState.description,
            onValueChange = { onAction(UiAction.DescriptionChanged(it)) },
            label = { Text("Açıklama") },
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            shape = RoundedCornerShape(16.dp),
        )

    }
}

@Preview(showBackground = true)
@Composable
fun ExperienceInfoScreenPreview(
    @PreviewParameter(ExperienceInfoScreenPreviewProvider::class) uiState: UiState,
) {
    ExperienceInfoScreen(
        uiState = uiState,
        uiEffect = emptyFlow(),
        onAction = {},
    )
}