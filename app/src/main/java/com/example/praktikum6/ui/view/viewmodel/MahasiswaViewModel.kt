package com.example.praktikum6.ui.view.viewmodel

import androidx.lifecycle.ViewModel
import com.example.praktikum6.ui.model.Mahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MahasiswaViewModel : ViewModel() {
    //Request
    private val _statusUI = MutableStateFlow(Mahasiswa())

    val statusUI: StateFlow<Mahasiswa> = _statusUI.asStateFlow()

    fun setMahasiswa(ls: MutableList<String>) {
        _statusUI.update { statusSaatIni ->
            statusSaatIni.copy(
                nim = ls[0],
                nama = ls[1],
                email = ls[2]
            )
        }
    }

    fun setMatakuliah(ls: MutableList<String>) {
        _statusUI.update { statusSaatIni ->
            statusSaatIni.copy(
                namamk = ls[0],
                kelas = ls[1],
            )

        }
    }
}