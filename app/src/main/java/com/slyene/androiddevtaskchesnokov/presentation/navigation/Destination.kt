package com.slyene.androiddevtaskchesnokov.presentation.navigation

import androidx.annotation.StringRes
import com.slyene.androiddevtaskchesnokov.R

sealed class Destination(val route: String, @StringRes val title: Int = -1) {
    object CardScreen : Destination("card_screen", R.string.card_screen_title)

    companion object{
        fun getCurrentDestinationTitleResId(route: String?): Int? =
            when (route) {
                CardScreen.route -> CardScreen.title
                else -> null
            }
    }
}
