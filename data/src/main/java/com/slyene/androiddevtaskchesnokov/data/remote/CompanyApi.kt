package com.slyene.androiddevtaskchesnokov.data.remote

import com.slyene.androiddevtaskchesnokov.data.remote.dto.companies_list_dto.CompanyListDto
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface CompanyApi {
    companion object {
        const val BASE_URL = "http://devapp.bonusmoney.pro/mobileapp/"
        const val TOKEN = "TOKEN: 123"
    }

    @Headers(TOKEN)
    @POST("getAllCompanies")
    suspend fun getCompanies(@Body body: CompanyRequestBody): CompanyListDto
}

