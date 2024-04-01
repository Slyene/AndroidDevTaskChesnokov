package com.slyene.androiddevtaskchesnokov.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.slyene.androiddevtaskchesnokov.R

@Composable
fun AndroidDevTaskChesnokovAppBar(
    title: String?,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.white))
    ) {
        AndroidDevTaskChesnokovText(
            text = title ?: "",
            modifier = Modifier
                .align(Alignment.Center)
                .padding(vertical = dimensionResource(id = R.dimen.margin1)),
            fontSize = dimensionResource(id = R.dimen.text1).value.sp,
            color = colorResource(id = R.color.blue)
        )
    }
}

@Composable
@Preview
fun AndroidDevTaskChesnokovAppBarPreview() {
    AndroidDevTaskChesnokovAppBar(
        title = "Управление картами",
        modifier = Modifier
    )
}