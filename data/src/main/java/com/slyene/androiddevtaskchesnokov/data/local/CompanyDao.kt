package com.slyene.androiddevtaskchesnokov.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.slyene.androiddevtaskchesnokov.data.local.entity.company_entity.CompanyEntity

@Dao
interface CompanyDao {

    @Insert
    suspend fun insertAll(companies: List<CompanyEntity>)

    @Query("DELETE FROM company")
    suspend fun clearAll()

    @Query("SELECT * FROM company")
    fun getPagingSource(): PagingSource<Int, CompanyEntity>
}