package com.slyene.androiddevtaskchesnokov.data

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.slyene.androiddevtaskchesnokov.data.local.CompanyDatabase
import com.slyene.androiddevtaskchesnokov.data.local.entity.company_entity.CompanyEntity
import com.slyene.androiddevtaskchesnokov.data.mappers.toCompanyEntity
import com.slyene.androiddevtaskchesnokov.data.remote.CompanyRequestBody
import com.slyene.androiddevtaskchesnokov.data.repository.DatabaseRepository
import com.slyene.androiddevtaskchesnokov.data.repository.NetworkRepository
import retrofit2.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class CompanyRemoteMediator(
    private val companyDb: CompanyDatabase,
    private val databaseRepository: DatabaseRepository,
    private val networkRepository: NetworkRepository

) : RemoteMediator<Int, CompanyEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, CompanyEntity>
    ): MediatorResult {
        return try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> 0
                LoadType.PREPEND -> {
                    return MediatorResult.Success(endOfPaginationReached = true)
                }

                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()

                    if (lastItem == null) {
                        return MediatorResult.Success(endOfPaginationReached = true)
                    }

                    lastItem.id
                }
            }

            val body = CompanyRequestBody(
                offset = loadKey.toString(),
                limit = state.config.pageSize.toString()
            )

            var id = loadKey

            val companies = networkRepository.getCompanies(body = body)
                .companies.map {
                    it.toCompanyEntity(id = ++id)
                }

            companyDb.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    databaseRepository.clearAll()
                }
                databaseRepository.insertAll(companies)
            }

            MediatorResult.Success(endOfPaginationReached = companies.isEmpty())
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }
}