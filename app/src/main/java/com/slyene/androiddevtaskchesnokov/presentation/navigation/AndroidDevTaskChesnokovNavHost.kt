package com.slyene.androiddevtaskchesnokov.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.paging.compose.collectAsLazyPagingItems
import com.slyene.androiddevtaskchesnokov.R
import com.slyene.androiddevtaskchesnokov.presentation.screens.card_screen.CardScreen
import com.slyene.androiddevtaskchesnokov.presentation.screens.card_screen.CardScreenViewModel

@Composable
fun AndroidDevTaskChesnokovNavHost(
    navController: NavHostController,
    cardScreenViewModel: CardScreenViewModel,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    NavHost(
        navController = navController,
        startDestination = Destination.CardScreen.route,
        modifier = modifier
    ) {
        composable(route = Destination.CardScreen.route) {
            val buttonPressedResource = stringResource(id = R.string.button_pressed)
            val companyIdResource = stringResource(id = R.string.company_id)
            val errorString = stringResource(id = R.string.error)

            CardScreen(
                onButtonClick = { buttonName, companyId ->
                    cardScreenViewModel.changeAlertText(
                        alertText = "$buttonPressedResource $buttonName, $companyIdResource $companyId"
                    )
                    cardScreenViewModel.showAlertDialog()
                },
                onDismissRequest = { cardScreenViewModel.closeAlertDialog() },
                onError = { errorMessage ->
                    if (errorMessage != null) {
                        cardScreenViewModel.changeAlertText(alertText = errorMessage)
                    } else {
                        cardScreenViewModel.changeAlertText(alertText = errorString)
                    }

                    cardScreenViewModel.showAlertDialog()
                },
                onRefresh = { companies -> cardScreenViewModel.refresh(companies) },
                onEndRefresh = { cardScreenViewModel.changeRefreshState() },
                companies = cardScreenViewModel.companyPagingFlow.collectAsLazyPagingItems(),
                cardScreenUiState = cardScreenViewModel.uiState,
                modifier = Modifier.padding(contentPadding)
            )
        }
    }
}