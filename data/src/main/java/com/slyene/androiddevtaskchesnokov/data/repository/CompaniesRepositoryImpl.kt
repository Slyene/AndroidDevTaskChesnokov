package com.slyene.androiddevtaskchesnokov.data.repository

import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.map
import com.slyene.androiddevtaskchesnokov.data.local.entity.company_entity.CompanyEntity
import com.slyene.androiddevtaskchesnokov.data.mappers.toCompany
import com.slyene.androiddevtaskchesnokov.domain.model.Company
import com.slyene.androiddevtaskchesnokov.domain.repository.CompaniesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.koin.java.KoinJavaComponent.inject

class CompaniesRepositoryImpl : CompaniesRepository {
    override fun getCompaniesPaged(): Flow<PagingData<Company>> {
        val pager: Pager<Int, CompanyEntity> by inject(Pager::class.java)
        return pager.flow.map { pagingData ->
            pagingData.map { it.toCompany() }
        }
    }
}