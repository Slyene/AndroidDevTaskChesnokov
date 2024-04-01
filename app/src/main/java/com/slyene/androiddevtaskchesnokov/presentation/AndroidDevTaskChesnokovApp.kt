package com.slyene.androiddevtaskchesnokov.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.slyene.androiddevtaskchesnokov.presentation.components.AndroidDevTaskChesnokovAppBar
import com.slyene.androiddevtaskchesnokov.presentation.navigation.AndroidDevTaskChesnokovNavHost
import com.slyene.androiddevtaskchesnokov.presentation.navigation.Destination
import org.koin.androidx.compose.koinViewModel

@Composable
fun AndroidDevTaskChesnokovApp(
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = stringResource(
        id = Destination.getCurrentDestinationTitleResId(backStackEntry?.destination?.route)
            ?: Destination.CardScreen.title
    )

    Scaffold(
        topBar = {
            AndroidDevTaskChesnokovAppBar(title = currentDestination)
        }
    ) { contentPadding ->
        AndroidDevTaskChesnokovNavHost(
            navController = navController,
            cardScreenViewModel = koinViewModel(),
            modifier = Modifier.fillMaxSize(),
            contentPadding = contentPadding
        )
    }
}