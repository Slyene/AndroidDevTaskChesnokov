package com.slyene.androiddevtaskchesnokov.data.remote.dto.companies_list_dto

data class CompanyRemote(
    val company: CompanyIdRemote = CompanyIdRemote(),
    val customerMarkParameters: CustomerMarkParametersRemote = CustomerMarkParametersRemote(),
    val mobileAppDashboard: MobileAppDashboardRemote = MobileAppDashboardRemote()
)