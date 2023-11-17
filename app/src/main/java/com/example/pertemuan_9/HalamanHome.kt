package com.example.pertemuan_9

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

@Composable
fun HalamanHome(
    onNextButtonClicked: () -> Unit
) {
    val image = painterResource(id = R.drawable.wartortle)
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Button(modifier = Modifier.weight(1f),
            onClick = onNextButtonClicked
        ) {
            Text(stringResource(R.string.next))
        }
    }
}