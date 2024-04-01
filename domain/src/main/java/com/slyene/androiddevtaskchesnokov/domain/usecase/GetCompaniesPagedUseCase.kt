package com.slyene.androiddevtaskchesnokov.domain.usecase

import androidx.paging.PagingData
import com.slyene.androiddevtaskchesnokov.domain.model.Company
import com.slyene.androiddevtaskchesnokov.domain.repository.CompaniesRepository
import kotlinx.coroutines.flow.Flow

class GetCompaniesPagedUseCase(
    private val companiesRepository: CompaniesRepository
) {
    operator fun invoke(): Flow<PagingData<Company>> {
        return companiesRepository.getCompaniesPaged()
    }
}