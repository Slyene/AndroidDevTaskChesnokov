@file:Suppress("SimplifyBooleanWithConstants")

package com.slyene.androiddevtaskchesnokov.presentation.screens.card_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import com.slyene.androiddevtaskchesnokov.R
import com.slyene.androiddevtaskchesnokov.domain.model.Company
import com.slyene.androiddevtaskchesnokov.presentation.components.AndroidDevTaskChesnokovText
import com.slyene.androiddevtaskchesnokov.presentation.components.AndroidDevTaskPullToRefreshLazyColumn
import com.slyene.androiddevtaskchesnokov.presentation.screens.card_screen.components.CardAlertDialog
import com.slyene.androiddevtaskchesnokov.presentation.screens.card_screen.components.CardCircularProgressIndicator
import com.slyene.androiddevtaskchesnokov.presentation.screens.card_screen.components.CardItem
import kotlinx.coroutines.flow.StateFlow

@Composable
fun CardScreen(
    onButtonClick: (String, String) -> Unit,
    onDismissRequest: () -> Unit,
    onError: (String?) -> Unit,
    onRefresh: (LazyPagingItems<Company>) -> Unit,
    onEndRefresh: () -> Unit,
    companies: LazyPagingItems<Company>,
    cardScreenUiState: StateFlow<CardScreenUiState>,
    modifier: Modifier = Modifier
) {
    val uiState by cardScreenUiState.collectAsStateWithLifecycle()

    if (uiState.showAlert) {
        CardAlertDialog(
            text = uiState.alertText,
            onDismissRequest = onDismissRequest
        )
    }

    LaunchedEffect(key1 = companies.loadState) {
        if (companies.loadState.refresh is LoadState.Error) {
            onError((companies.loadState.refresh as LoadState.Error).error.localizedMessage)
        } else if (companies.loadState.append is LoadState.Error) {
            onError((companies.loadState.append as LoadState.Error).error.localizedMessage)
        }
    }

    LaunchedEffect(key1 = companies.loadState) {
        if (
            (companies.loadState.refresh is LoadState.NotLoading ||
            companies.loadState.refresh is LoadState.Error) && uiState.isRefreshing
        ) {
            onEndRefresh()
        }
    }

    Box(modifier = modifier.fillMaxSize()) {
        AndroidDevTaskPullToRefreshLazyColumn(
            isRefreshing = uiState.isRefreshing,
            onRefresh = { onRefresh(companies) },
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(dimensionResource(id = R.dimen.margin1)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.margin1)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(
                count = companies.itemCount,
                key = companies.itemKey { item -> item.id },
                contentType = companies.itemContentType { item -> "company_${item.id}" }
            ) { index ->
                if (companies[index] != null) {
                    CardItem(company = companies[index]!!, onButtonClick = onButtonClick)
                }
            }

            if (
                companies.loadState.refresh is LoadState.Loading ||
                companies.loadState.append is LoadState.Loading
            ) {
                item { CardCircularProgressIndicator() }
            } else if (
                companies.loadState.refresh is LoadState.Error &&
                companies.itemCount == 0
            ) {
                item {
                    AndroidDevTaskChesnokovText(
                        text = stringResource(id = R.string.no_companies),
                        fontSize = dimensionResource(id = R.dimen.text2).value.sp,
                        color = colorResource(id = R.color.black)
                    )
                }
            }
        }
    }
}