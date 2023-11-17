package com.example.coba

import androidx.lifecycle.ViewModel
import com.example.pertemuan_9.Data.FormatUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class FormViewModel: ViewModel() {
    private val _stateUI = MutableStateFlow(FormatUIState())
    val stateUI: StateFlow<FormatUIState> = _stateUI.asStateFlow()

    fun setData(ListContact : MutableList<String>) {
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(
                nama = ListContact[0],
                nim = ListContact[1],
                konsentrasi = ListContact[2],
                judul = ListContact[3]
            )
        }
    }

    fun setDosenPem1(DosenPembimbing1: String) {
        _stateUI.update { stateSaatIni -> stateSaatIni.copy(dospem1 = DosenPembimbing1) }
    }

    fun setDosenPem2(DosenPembimbing2: String) {
        _stateUI.update { stateSaatIni -> stateSaatIni.copy(dospem2 = DosenPembimbing2) }
    }

}