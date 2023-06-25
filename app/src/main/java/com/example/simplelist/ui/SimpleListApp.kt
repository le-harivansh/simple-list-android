package com.example.simplelist.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.simplelist.R
import com.example.simplelist.ui.screens.CreateNewItemScreen
import com.example.simplelist.ui.screens.HomeScreen
import com.example.simplelist.ui.screens.HomeScreenViewModel
import com.example.simplelist.ui.screens.Route

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleListApp() {
    val navController = rememberNavController()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { TopAppBar(scrollBehavior = scrollBehavior) },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(Route.CreateItem.routeName) }) {
                Text(text = "+")
            }
        }
    ) {
        Surface(modifier = Modifier
            .fillMaxSize()
            .padding(it)) {
            val viewModel: HomeScreenViewModel = viewModel(factory = HomeScreenViewModel.Factory)

            NavHost(navController = navController, startDestination = Route.Home.routeName) {
                composable(route = Route.Home.routeName) {
                    HomeScreen(
                        uiState = viewModel.uiState,
                        deleteItem = { itemId -> viewModel.deleteItem(itemId) }
                    )
                }

                composable(route = Route.CreateItem.routeName) {
                    CreateNewItemScreen { newItemTitle ->
                        viewModel.createNewItem(newItemTitle)

                        navController.navigate(Route.Home.routeName)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(scrollBehavior: TopAppBarScrollBehavior, modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Text(
                text = stringResource(id = R.string.app_name)
            )
        },
        modifier = modifier
    )
}
