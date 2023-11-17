package com.example.pertemuan_9
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel


enum class PengelolaHalaman {
    Home,
    Form,
    Summary
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PengelolaHalaman(
    viewModel: ViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    Scaffold { inner ->
        val uiState by viewModel.stateUI.collectAsState()
        NavHost(
            navController = navController,
            startDestination = PengelolaHalaman.Home.name,
            modifier = Modifier.padding(inner)
        ) {
            composable(route = PengelolaHalaman.Home.name) {
                HalamanHome(
                    onNextButtonClicked = {
                        navController.navigate(PengelolaHalaman.Form.name)
                    }
                )
            }
            composable(route = PengelolaHalaman.Form.name) {
                val context = LocalContext.current
                HalamanForm(
                    dosenpembimbing1 = dosen1.map { id -> context.resources.getString(id) },
                    dosenpembimbing2 = dosen1.map { id -> context.resources.getString(id) },
                    onSelectionChanged1 = {viewModel.(it)},
                    onSelectionChanged2 = {viewModel.setDosenPem2(it)},
                    onSubmitClicked = {viewModel.setData(it)
                        navController.navigate(PengelolaHalaman.Summary.name)
                    },
                )
            }
            composable(route = PengelolaHalaman.Summary.name) {
                HalamanSubmit(FormatUIState = uiState, onCancelButtonClicked = { navController.popBackStack(PengelolaHalaman.Form.name,inclusive = false) })
            }
        }
    }
}