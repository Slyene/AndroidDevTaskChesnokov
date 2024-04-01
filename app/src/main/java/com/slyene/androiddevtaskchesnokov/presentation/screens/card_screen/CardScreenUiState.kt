package com.slyene.androiddevtaskchesnokov.presentation.screens.card_screen

data class CardScreenUiState(
    val showAlert: Boolean = false,
    val alertText: String = "",
    val isRefreshing: Boolean = false
)
