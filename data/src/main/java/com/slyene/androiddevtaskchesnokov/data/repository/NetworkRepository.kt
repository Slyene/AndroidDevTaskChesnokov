package com.slyene.androiddevtaskchesnokov.data.repository

import com.slyene.androiddevtaskchesnokov.data.remote.CompanyRequestBody
import com.slyene.androiddevtaskchesnokov.data.remote.dto.companies_list_dto.CompanyListDto
import retrofit2.http.Body

interface NetworkRepository {

    suspend fun getCompanies(@Body body: CompanyRequestBody): CompanyListDto
}