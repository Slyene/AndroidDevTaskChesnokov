package com.slyene.androiddevtaskchesnokov.data.mappers

import com.slyene.androiddevtaskchesnokov.data.local.entity.company_entity.CompanyEntity
import com.slyene.androiddevtaskchesnokov.data.remote.dto.companies_list_dto.CompanyRemote
import com.slyene.androiddevtaskchesnokov.domain.model.Company

fun CompanyRemote.toCompanyEntity(id: Int): CompanyEntity = CompanyEntity(
    id = id,
    companyId = company.companyId,
    cashToMark = customerMarkParameters.loyaltyLevel.cashToMark,
    markToCash = customerMarkParameters.loyaltyLevel.markToCash,
    name = customerMarkParameters.loyaltyLevel.name,
    number = customerMarkParameters.loyaltyLevel.number,
    requiredSum = customerMarkParameters.loyaltyLevel.requiredSum,
    mark = customerMarkParameters.mark,
    accentColor = mobileAppDashboard.accentColor,
    backgroundColor = mobileAppDashboard.backgroundColor,
    cardBackgroundColor = mobileAppDashboard.cardBackgroundColor,
    companyName = mobileAppDashboard.companyName,
    highlightTextColor = mobileAppDashboard.highlightTextColor,
    logo = mobileAppDashboard.logo,
    mainColor = mobileAppDashboard.mainColor,
    textColor = mobileAppDashboard.textColor
)

fun CompanyEntity.toCompany(): Company = Company(
    id,
    companyId,
    cashToMark,
    markToCash,
    name,
    number,
    requiredSum,
    mark,
    accentColor,
    backgroundColor,
    cardBackgroundColor,
    companyName,
    highlightTextColor,
    logo,
    mainColor,
    textColor
)