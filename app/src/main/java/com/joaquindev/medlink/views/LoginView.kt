package com.joaquindev.medlink.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.joaquindev.medlink.components.CustomTextButton
import com.joaquindev.medlink.components.SectionParagraph
import com.joaquindev.medlink.components.SectionTitle
import com.joaquindev.medlink.components.SessionAppBar
import com.joaquindev.medlink.components.SessionBox
import com.joaquindev.medlink.components.SessionButton
import com.joaquindev.medlink.components.SpaceH

@Composable
fun LoginView(navController: NavController) {
    Scaffold(
        topBar = {
            SessionAppBar(
                title = "Iniciar sesión",
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
            LoginViewContent(navController)
        }
    }
}

@Composable
fun  LoginViewContent(navController: NavController) {
    val scrollState = rememberScrollState() // Variable para controlar el scroll de la columna
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp)
            .verticalScroll(scrollState) // Agregamos el scroll vertical a la columna
    ) {
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        SectionTitle(
            title = "Bienvenido de nuevo",
            color = MaterialTheme.colorScheme.primary,
        )
        SectionParagraph("La mejor manera de gestionar tu salud y bienestar la encuentras aquí")
        SpaceH(30.dp)
        SectionTitle(
            title = "Correo electrónico",
            color = Color.Black,
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = email,
            onValueChange = { email = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            colors = TextFieldDefaults.colors(
                focusedTextColor = MaterialTheme.colorScheme.onTertiary,
                unfocusedTextColor = MaterialTheme.colorScheme.onTertiary,
                cursorColor = MaterialTheme.colorScheme.secondary,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = MaterialTheme.colorScheme.tertiary,
                unfocusedContainerColor = MaterialTheme.colorScheme.tertiary,
            ),
            shape = RoundedCornerShape(15.dp)
        )
        SpaceH()
        SectionTitle(
            title = "Contraseña",
            color = Color.Black
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = password,
            onValueChange = { password = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            colors = TextFieldDefaults.colors(
                focusedTextColor = MaterialTheme.colorScheme.onTertiary,
                unfocusedTextColor = MaterialTheme.colorScheme.onTertiary,
                cursorColor = MaterialTheme.colorScheme.secondary,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = MaterialTheme.colorScheme.tertiary,
                unfocusedContainerColor = MaterialTheme.colorScheme.tertiary,
            ),
            shape = RoundedCornerShape(15.dp)
        )
        CustomTextButton(
            "Olvide mi contraseña",
            onClick = { navController.navigate("RecoverPassword") }
        )
        SpaceH(30.dp)
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SessionButton(
                "Iniciar sesión",
                MaterialTheme.colorScheme.primary,
                textColor = MaterialTheme.colorScheme.onPrimary,
                onclick = { navController.navigate("Home") }
            )
            SpaceH(30.dp)
            SectionParagraph("O iniciar sesión con")
            SpaceH(30.dp)
            SessionBox(
                onclick = { /* Sesión o registro con google*/ }
            )
            SpaceH(30.dp)
            SectionParagraph("¿Aún no tienes una cuenta?")
            CustomTextButton(
                "Registrate",
                onClick = { navController.navigate("Register") }
            )
        }
    }
}