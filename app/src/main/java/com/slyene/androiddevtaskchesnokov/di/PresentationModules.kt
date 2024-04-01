package com.slyene.androiddevtaskchesnokov.di

import com.slyene.androiddevtaskchesnokov.presentation.screens.card_screen.CardScreenViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { CardScreenViewModel(get()) }
}

val presentationModules = listOf(viewModelModule)