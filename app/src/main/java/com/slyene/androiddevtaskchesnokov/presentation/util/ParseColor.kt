package com.slyene.androiddevtaskchesnokov.presentation.util

import androidx.compose.ui.graphics.Color

fun parseColor(color: String): Color =
    Color(android.graphics.Color.parseColor(color))
