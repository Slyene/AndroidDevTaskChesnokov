package com.slyene.androiddevtaskchesnokov.data.local.entity.company_entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "company"
)
data class CompanyEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val companyId: String = "",
    val cashToMark: Int = 0,
    val markToCash: Int = 0,
    val name: String = "",
    val number: Int = 0,
    val requiredSum: Int = 0,
    val mark: Int = 0,
    val accentColor: String = "",
    val backgroundColor: String = "",
    val cardBackgroundColor: String = "",
    val companyName: String = "",
    val highlightTextColor: String = "",
    val logo: String = "",
    val mainColor: String = "",
    val textColor: String = ""
)