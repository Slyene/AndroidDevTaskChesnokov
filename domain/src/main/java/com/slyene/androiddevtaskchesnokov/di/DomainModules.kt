package com.slyene.androiddevtaskchesnokov.di

import com.slyene.androiddevtaskchesnokov.domain.usecase.GetCompaniesPagedUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetCompaniesPagedUseCase(get()) }
}

val domainModules = listOf(useCaseModule)