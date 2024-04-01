package com.slyene.androiddevtaskchesnokov.data.remote.repository

import com.slyene.androiddevtaskchesnokov.data.remote.CompanyApi
import com.slyene.androiddevtaskchesnokov.data.remote.CompanyRequestBody
import com.slyene.androiddevtaskchesnokov.data.remote.dto.companies_list_dto.CompanyListDto
import com.slyene.androiddevtaskchesnokov.data.repository.NetworkRepository

class NetworkRepositoryImpl(
    private val api: CompanyApi
) : NetworkRepository {

    override suspend fun getCompanies(body: CompanyRequestBody): CompanyListDto {
        return api.getCompanies(body)
    }
}