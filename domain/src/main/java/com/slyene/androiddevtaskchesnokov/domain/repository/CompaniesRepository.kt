package com.slyene.androiddevtaskchesnokov.domain.repository

import androidx.paging.PagingData
import com.slyene.androiddevtaskchesnokov.domain.model.Company
import kotlinx.coroutines.flow.Flow

interface CompaniesRepository {
    fun getCompaniesPaged(): Flow<PagingData<Company>>
}