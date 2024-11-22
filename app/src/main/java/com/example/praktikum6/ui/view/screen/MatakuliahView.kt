package com.example.praktikum6.ui.view.screen


import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.praktikum6.ui.model.Mahasiswa

@Composable
fun MatakuliahView(
    uiState: Mahasiswa,
    onSubmitButtonClicked: (MutableList<String>) -> Unit
)
{
    var namamk by remember { mutableStateOf("") }
    var kelas by remember { mutableStateOf("") }

    var listData : MutableList<String> = mutableListOf(namamk, kelas)

}