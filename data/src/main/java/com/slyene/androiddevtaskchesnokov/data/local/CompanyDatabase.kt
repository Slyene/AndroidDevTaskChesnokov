package com.slyene.androiddevtaskchesnokov.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.slyene.androiddevtaskchesnokov.data.local.entity.company_entity.CompanyEntity

@Database(
   entities = [CompanyEntity::class],
   version = 1
)
abstract class CompanyDatabase() : RoomDatabase() {

   abstract val dao: CompanyDao
}