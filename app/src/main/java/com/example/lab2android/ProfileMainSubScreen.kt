package com.example.lab2android

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProfileMainSubScreen(
    viewModel: MainViewModel,
    onNavigateToOldLayout: () -> Unit,
    onNavigateToSecond: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = viewModel.profileMessage)

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { viewModel.updateProfile() }) {
            Text("Оновити профіль")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onNavigateToOldLayout) {
            Text("Перейти до старої розмітки (Лаба 1)")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onNavigateToSecond) {
            Text("Перейти до другого підекрану")
        }
    }
}
