package com.slyene.androiddevtaskchesnokov.data.local.repository

import androidx.paging.PagingSource
import com.slyene.androiddevtaskchesnokov.data.local.CompanyDao
import com.slyene.androiddevtaskchesnokov.data.local.entity.company_entity.CompanyEntity
import com.slyene.androiddevtaskchesnokov.data.repository.DatabaseRepository

class DatabaseRepositoryImpl(
    private val dao: CompanyDao
) : DatabaseRepository {
    override suspend fun insertAll(companies: List<CompanyEntity>) {
        dao.insertAll(companies)
    }

    override suspend fun clearAll() {
        dao.clearAll()
    }

    override fun getPagingSource(): PagingSource<Int, CompanyEntity> {
        return dao.getPagingSource()
    }
}