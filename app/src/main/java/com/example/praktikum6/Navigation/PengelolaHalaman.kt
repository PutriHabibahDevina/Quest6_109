package com.example.praktikum6.Navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.praktikum6.ui.view.screen.MahasiswaFormView
import com.example.praktikum6.ui.view.screen.MatakuliahView
import com.example.praktikum6.ui.view.screen.SplashView
import com.example.praktikum6.ui.view.screen.TampilView
import com.example.praktikum6.ui.view.viewmodel.MahasiswaViewModel

enum class Halaman{
    Splash,
    Mahasiswa,
    Matakuliah,
    Tampil
}

@Composable
fun NavigationControl (
    modifier: Modifier = Modifier,
    viewModel: MahasiswaViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
){
    val uistate by viewModel.statusUI.collectAsState()
    NavHost(
        navController = navController,
        startDestination = Halaman.Splash.name,
        modifier = Modifier.padding()
    ){
        composable(
            route = Halaman.Splash.name
        ){
            SplashView(
                onSubmitButtonClicked = {
                    navController.navigate(Halaman.Mahasiswa.name)
                }
            )
        }
        composable(
            route = Halaman.Mahasiswa.name
        ){
            MahasiswaFormView(
                onSubmitButtonClicked = {
                    viewModel.setMahasiswa(it)
                    navController.navigate(Halaman.Matakuliah.name)},
                onBackButtonClicked = {navController.popBackStack()}
            )
        }
        composable(
            route = Halaman.Matakuliah.name
        ){
            MatakuliahView(
                uiState = uistate,
                onSubmitButtonClicked = {
                    viewModel.setMatakuliah(it)
                    navController.navigate(Halaman.Tampil.name)
                },
            )
        }

    }
}