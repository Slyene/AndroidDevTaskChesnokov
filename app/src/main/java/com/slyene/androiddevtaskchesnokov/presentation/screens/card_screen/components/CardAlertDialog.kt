@file:OptIn(ExperimentalMaterial3Api::class)

package com.slyene.androiddevtaskchesnokov.presentation.screens.card_screen.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.slyene.androiddevtaskchesnokov.R
import com.slyene.androiddevtaskchesnokov.presentation.ui.theme.AndroidDevTaskChesnokovTheme
import com.slyene.androiddevtaskchesnokov.presentation.ui.theme.Segoe

@Composable
fun CardAlertDialog(
    text: String,
    onDismissRequest: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        confirmButton = {},
        text = { Text(
            text = text,
            fontSize = dimensionResource(id = R.dimen.text2).value.sp,
            fontFamily = Segoe,
            color = colorResource(id = R.color.black)
        ) },
        dismissButton = {
            TextButton(onClick = onDismissRequest) {
                Text(text = "OK")
            }
        }
    )
}

@Composable
@Preview
fun CardBasicAlertDialogPreview() {
    AndroidDevTaskChesnokovTheme {
        CardAlertDialog(text = "Hello World", onDismissRequest = {})
    }
}