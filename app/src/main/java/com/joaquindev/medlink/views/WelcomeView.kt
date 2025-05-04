package com.joaquindev.medlink.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun WelcomeView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        WelcomeViewContent()
    }
}

@Composable
fun WelcomeViewContent() {

}