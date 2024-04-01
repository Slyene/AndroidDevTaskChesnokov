package com.slyene.androiddevtaskchesnokov.data.remote.dto.companies_list_dto

data class CustomerMarkParametersRemote(
    val loyaltyLevel: LoyaltyLevelRemote = LoyaltyLevelRemote(),
    val mark: Int = 0
)