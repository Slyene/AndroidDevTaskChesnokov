package com.slyene.androiddevtaskchesnokov.presentation.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.slyene.androiddevtaskchesnokov.R
import com.slyene.androiddevtaskchesnokov.presentation.ui.theme.Segoe

@Composable
fun AndroidDevTaskChesnokovText(
    text: String,
    modifier: Modifier = Modifier,
    fontFamily: FontFamily = Segoe,
    fontSize: TextUnit = dimensionResource(id = R.dimen.text2).value.sp,
    fontWeight: FontWeight = FontWeight.Normal,
    color: Color = colorResource(id = R.color.black)
) {
    Text(
        text = text,
        modifier = modifier,
        fontFamily = fontFamily,
        fontSize = fontSize,
        fontWeight = fontWeight,
        color = color
    )
}