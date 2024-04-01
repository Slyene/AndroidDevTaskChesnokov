package com.slyene.androiddevtaskchesnokov.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.slyene.androiddevtaskchesnokov.R

@Composable
fun AndroidDevTaskPullToRefreshIndicator(
    modifier: Modifier = Modifier,
    size: Dp = 40.dp,
    color: Color = colorResource(id = R.color.blue),
    strokeWidth: Dp = 3.dp,
    trackColor: Color = colorResource(id = R.color.white),
    strokeCap: StrokeCap = StrokeCap.Round
) {
    Box(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(
            modifier = modifier.size(size / 2).align(Alignment.Center),
            color = color,
            strokeWidth = strokeWidth,
            trackColor = trackColor,
            strokeCap = strokeCap
        )
    }
}

@Composable
fun AndroidDevTaskPullToRefreshIndicator(
    progress: () -> Float,
    modifier: Modifier = Modifier,
    size: Dp = 40.dp,
    color: Color = colorResource(id = R.color.blue),
    strokeWidth: Dp = 3.dp,
    trackColor: Color = colorResource(id = R.color.white),
    strokeCap: StrokeCap = StrokeCap.Round
) {
    Box(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(
            progress = progress,
            modifier = modifier.size(size / 2).align(Alignment.Center),
            color = color,
            strokeWidth = strokeWidth,
            trackColor = trackColor,
            strokeCap = strokeCap
        )
    }
}
