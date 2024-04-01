package com.slyene.androiddevtaskchesnokov.data.remote.dto.companies_list_dto

data class LoyaltyLevelRemote(
    val cashToMark: Int = 0,
    val markToCash: Int = 0,
    val name: String = "",
    val number: Int = 0,
    val requiredSum: Int = 0
)