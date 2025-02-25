package com.salihakbas.cvmaker.ui.personalinfo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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
import com.salihakbas.cvmaker.ui.components.LoadingBar
import com.salihakbas.cvmaker.ui.personalinfo.PersonalInfoContract.UiAction
import com.salihakbas.cvmaker.ui.personalinfo.PersonalInfoContract.UiEffect
import com.salihakbas.cvmaker.ui.personalinfo.PersonalInfoContract.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun PersonalInfoScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
) {
    when {
        uiState.isLoading -> LoadingBar()
        uiState.list.isNotEmpty() -> EmptyScreen()
        else -> PersonalInfoContent(
            uiState = uiState,
            onAction = onAction
        )
    }
}

@Composable
fun PersonalInfoContent(
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
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            PersonalInfoTextField(
                value = uiState.name,
                onValueChange = { onAction(UiAction.NameChanged(it)) },
                labelText = "Ad",
                modifier = Modifier.weight(1f),
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_person),
                        contentDescription = null
                    )
                }
            )
            PersonalInfoTextField(
                value = uiState.surname,
                onValueChange = { onAction(UiAction.SurnameChanged(it)) },
                labelText = "Soyad",
                modifier = Modifier.weight(1f),
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_person),
                        contentDescription = null
                    )
                }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        PersonalInfoTextField(
            value = uiState.email,
            onValueChange = { onAction(UiAction.EmailChanged(it)) },
            labelText = "Email",
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_email),
                    contentDescription = null
                )
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        PersonalInfoTextField(
            value = uiState.phoneNumber,
            onValueChange = { onAction(UiAction.PhoneNumberChanged(it)) },
            labelText = "Telefon Numarası",
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_phone),
                    contentDescription = null
                )
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        PersonalInfoTextField(
            value = uiState.website,
            onValueChange = { onAction(UiAction.WebsiteChanged(it)) },
            labelText = "Website",
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_language),
                    contentDescription = null
                )
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        PersonalInfoTextField(
            value = uiState.location,
            onValueChange = { onAction(UiAction.LocationChanged(it)) },
            labelText = "Konum",
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_location),
                    contentDescription = null
                )
            }
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            Text(
                text = "Kaydet"
            )
        }
    }
}

@Composable
fun PersonalInfoTextField(
    value: String,
    onValueChange: (String) -> Unit,
    labelText: String,
    modifier: Modifier,
    leadingIcon: @Composable (() -> Unit)? = null
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = labelText) },
        modifier = modifier,
        leadingIcon = leadingIcon,
        shape = RoundedCornerShape(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun PersonalInfoScreenPreview(
    @PreviewParameter(PersonalInfoScreenPreviewProvider::class) uiState: UiState,
) {
    PersonalInfoScreen(
        uiState = uiState,
        uiEffect = emptyFlow(),
        onAction = {},
    )
}