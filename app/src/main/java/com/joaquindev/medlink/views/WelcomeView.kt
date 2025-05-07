package com.joaquindev.medlink.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.joaquindev.medlink.R
import com.joaquindev.medlink.components.SessionButton
import com.joaquindev.medlink.components.SpaceH

@Composable
fun WelcomeView(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize()
    ) {
        WelcomeViewContent(navController)
    }
}

@Composable
fun WelcomeViewContent(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp)
    ) {
        Image(
          painter = painterResource(id = R.drawable.medlink),
          contentDescription = "App Icon",
          modifier = Modifier.size(280.dp)
        )
        Text(
            text = "Empieza a gestionar tu bienestar hoy",
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.primary,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
        SpaceH(50.dp)
        Text(
            text = "Tu aliado en el seguimiento de tus tratamientos",
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
        Text(
            text = "Inicia sesión, o si aún no tienes una cuenta, registrate",
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
        )
        SpaceH(20.dp)
        SessionButton(
            "Iniciar sesión",
            MaterialTheme.colorScheme.primary,
            textColor = MaterialTheme.colorScheme.onPrimary,
            onclick = { navController.navigate("Login") }
        )
        SpaceH(20.dp)
        SessionButton(
            "Registrate",
            MaterialTheme.colorScheme.secondary,
            textColor = MaterialTheme.colorScheme.primary,
            onclick = { navController.navigate("Register") }
        )

    }
}