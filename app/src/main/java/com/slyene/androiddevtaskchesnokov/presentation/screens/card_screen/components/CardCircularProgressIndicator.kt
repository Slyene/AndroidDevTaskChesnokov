package com.slyene.androiddevtaskchesnokov.presentation.screens.card_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.slyene.androiddevtaskchesnokov.R
import com.slyene.androiddevtaskchesnokov.presentation.components.AndroidDevTaskChesnokovText

@Composable
fun CardCircularProgressIndicator(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(dimensionResource(id = R.dimen.preloaderSize)),
            color = colorResource(id = R.color.black)
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.margin2)))
        AndroidDevTaskChesnokovText(
            text = stringResource(id = R.string.loading_companies),
            fontSize = dimensionResource(id = R.dimen.text2).value.sp,
            color = colorResource(id = R.color.black)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun CardCircularProgressIndicatorPreview() {
    CardCircularProgressIndicator()
}