package com.pdmcourse2026.basictemplate.screens.results

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pdmcourse2026.basictemplate.Components.ResultCard
import java.nio.file.WatchEvent

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)
@Composable

fun ResultadosScreen(
    viewModel: ResultsViewModel = viewModel(),
    navigateToHome: () -> Unit
) {
    val options by viewModel.options.collectAsState()
    val loading by viewModel.loading.collectAsState()
    val saving by viewModel.saving.collectAsState()
    val error by viewModel.error.collectAsState()
    val saveMessage by viewModel.saveMessage.collectAsState()
    val refresh by viewModel.refreshing.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadOptions()
    }

    if (loading) {
        Scaffold(topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = { Text("Resultados") },
            )
        }) { paddingValues ->
            CircularProgressIndicator(modifier = Modifier.padding(paddingValues))
        }
        return
    }

    if (error != null) {
        Scaffold(topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = { Text("Resultados") },
            )
        }) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "${error}")
                Button(onClick = { viewModel.loadOptions() }) {
                    Text(
                        text = "Reintentar"
                    )
                }
            }
        }

    }
    Scaffold(topBar = {
        TopAppBar(
            colors = topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary
            ),
            title = { Text("Resultados") },
        )
    }) { paddingValues ->
        PullToRefreshBox(
            isRefreshing = refresh,
            onRefresh = { viewModel.refreshVotes()}
        ) {
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LazyColumn(
                    modifier = Modifier.height(700.dp), contentPadding = PaddingValues(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(options) { option ->
                        ResultCard(option)
                        Spacer(modifier = Modifier.height(5.dp))
                    }

                }
                Button(onClick = { navigateToHome() }) {
                    Text(text = "Volver a votar")
                }
            }
        }

    }


}