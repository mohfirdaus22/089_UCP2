package com.example.pertemuan_9
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.pertemuan_9.Data.FormatUIState


@Composable
fun HalamanSubmit(
    FormatUIState : FormatUIState,
    onCancelButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
){
    val items = listOf(
        Pair(stringResource(R.string.nama), FormatUIState.nama),
        Pair(stringResource(R.string.nim),  FormatUIState.nim),
        Pair(stringResource(R.string.konsentrasi),  FormatUIState.konsentrasi),
        Pair(stringResource(R.string.judul), FormatUIState.judul),
        Pair(stringResource(R.string.dospem1),  FormatUIState.dospem1),
        Pair(stringResource(R.string.dospem2),  FormatUIState.dospem2)
    )
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Column(
                modifier = Modifier
                    .padding(10.dp),

                ) {
                items.forEach { item ->
                    Column {
                        Text(item.first.uppercase())
                        Text(text = item.second.toString(), fontWeight = FontWeight.Bold)
                    }
                    Divider(thickness = 1.dp)
                    Spacer(modifier = Modifier.padding(10.dp))
                }
            }
            Row(
                modifier = Modifier
                    .weight(1f, false)
                    .padding(8.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedButton(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = onCancelButtonClicked
                    ) {
                        Text(stringResource(R.string.back))
                    }
                }
            }
        }
    }
}