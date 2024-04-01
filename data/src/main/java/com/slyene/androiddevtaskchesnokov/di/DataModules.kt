package com.slyene.androiddevtaskchesnokov.di

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.RemoteMediator
import androidx.room.Room
import com.slyene.androiddevtaskchesnokov.common.MAX_PAGING_DATA_ITEMS
import com.slyene.androiddevtaskchesnokov.common.PAGE_SIZE
import com.slyene.androiddevtaskchesnokov.data.CompanyRemoteMediator
import com.slyene.androiddevtaskchesnokov.data.local.CompanyDao
import com.slyene.androiddevtaskchesnokov.data.local.CompanyDatabase
import com.slyene.androiddevtaskchesnokov.data.local.entity.company_entity.CompanyEntity
import com.slyene.androiddevtaskchesnokov.data.local.repository.DatabaseRepositoryImpl
import com.slyene.androiddevtaskchesnokov.data.remote.CompanyApi
import com.slyene.androiddevtaskchesnokov.data.remote.repository.NetworkRepositoryImpl
import com.slyene.androiddevtaskchesnokov.data.repository.CompaniesRepositoryImpl
import com.slyene.androiddevtaskchesnokov.data.repository.DatabaseRepository
import com.slyene.androiddevtaskchesnokov.data.repository.NetworkRepository
import com.slyene.androiddevtaskchesnokov.domain.repository.CompaniesRepository
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@OptIn(ExperimentalPagingApi::class)
val paginationModule = module {
    single {
        Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                enablePlaceholders = false,
                maxSize = MAX_PAGING_DATA_ITEMS
            ),
            remoteMediator = get(),
            pagingSourceFactory = {
                get<CompanyDao>().getPagingSource()
            }
        )
    }

    single<RemoteMediator<Int, CompanyEntity>> {
        CompanyRemoteMediator(
            companyDb = get(),
            databaseRepository = get(),
            networkRepository = get()
        )
    }
}

val repositoryModule = module {
    single<DatabaseRepository> {
        DatabaseRepositoryImpl(get())
    }

    single<NetworkRepository> {
        NetworkRepositoryImpl(get())
    }

    single<CompaniesRepository> {
        CompaniesRepositoryImpl()
    }
}

val databaseModule = module {
    single{
        Room.databaseBuilder(
            context = get(),
            klass = CompanyDatabase::class.java,
            name = "company_db"
        ).fallbackToDestructiveMigration()
            .build()
    }

    single<CompanyDao> {
        get<CompanyDatabase>().dao
    }
}

val retrofitModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(CompanyApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CompanyApi::class.java)
    }
}

val dataModules = listOf(paginationModule, repositoryModule, databaseModule, retrofitModule)