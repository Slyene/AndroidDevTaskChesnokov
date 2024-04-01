package com.slyene.androiddevtaskchesnokov.data.repository

import androidx.paging.PagingSource
import com.slyene.androiddevtaskchesnokov.data.local.entity.company_entity.CompanyEntity

interface DatabaseRepository {
    suspend fun insertAll(companies: List<CompanyEntity>)

    suspend fun clearAll()

    fun getPagingSource(): PagingSource<Int, CompanyEntity>
}