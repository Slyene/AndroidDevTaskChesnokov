package com.slyene.androiddevtaskchesnokov.presentation.screens.card_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.compose.LazyPagingItems
import com.slyene.androiddevtaskchesnokov.domain.model.Company
import com.slyene.androiddevtaskchesnokov.domain.usecase.GetCompaniesPagedUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.koin.core.component.KoinComponent

class CardScreenViewModel(
    getCompaniesPagedUseCase: GetCompaniesPagedUseCase,
) : ViewModel(), KoinComponent {

    val companyPagingFlow = getCompaniesPagedUseCase()
        .cachedIn(viewModelScope)

    private val _uiState: MutableStateFlow<CardScreenUiState> =
        MutableStateFlow(CardScreenUiState())
    val uiState: StateFlow<CardScreenUiState> = _uiState.asStateFlow()

    fun showAlertDialog() {
        _uiState.update { it.copy(showAlert = true) }
    }

    fun closeAlertDialog() {
        _uiState.update { it.copy(showAlert = false) }
    }

    fun changeAlertText(alertText: String) {
        _uiState.update { it.copy(alertText = alertText) }
    }

    fun refresh(companies: LazyPagingItems<Company>) {
        changeRefreshState()
        companies.refresh()
    }

    fun changeRefreshState() {
        _uiState.update {
            it.copy(isRefreshing = !it.isRefreshing)
        }
    }
}
