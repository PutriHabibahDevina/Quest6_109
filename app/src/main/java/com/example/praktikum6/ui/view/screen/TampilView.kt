package com.example.praktikum6.ui.view.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.praktikum6.R
import com.example.praktikum6.ui.model.Mahasiswa

@Composable
fun TampilView(
    uiState: Mahasiswa,
    onBackButtonClicked: () -> Unit = {},
    onResetButtonClicked: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize().background(colorResource(id = R.color.primary)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column (
            modifier = Modifier.fillMaxSize()
                .background(Color.White,  shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                ) {
                    Spacer(modifier = Modifier.padding(50.dp))
                    Text("Nim:")
                    Text(uiState.nim)
                    Text("Nama:")
                    Text(uiState.nama)
                }
                Column(
                ) {
                    Text(uiState.email)
                }
            }
            Spacer(modifier = Modifier.padding(16.dp))
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row() {
                    Text("Matakuliah yang diambil:")
                    Text(uiState.namamk)
                }
                Row() {
                    Text(text = "Kelas:")
                    Text(uiState.kelas)
                }
            }
            Spacer(modifier = Modifier.padding(32.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = { onBackButtonClicked() }) {
                    Text(text = "Kembali")
                }
                Button(onClick = { onResetButtonClicked() }) {
                    Text(text = "Reset")
                }
            }
        }
    }
}