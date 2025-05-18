package com.joaquindev.medlink.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.joaquindev.medlink.components.SessionAppBar

@Composable
fun SettingsView(navController: NavController) {
    Scaffold(
        topBar = {
            SessionAppBar(
                title = "Mi perfil",
                onclick = { navController.popBackStack() }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.onPrimary)

        ) {
            SettingsViewContent()
        }
    }
}

@Composable
fun SettingsViewContent() {
    Text("Esta es la view de settings")
}