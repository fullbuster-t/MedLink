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
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.joaquindev.medlink.components.CustomBlockTextFiled
import com.joaquindev.medlink.components.CustomTextButton
import com.joaquindev.medlink.components.SectionParagraph
import com.joaquindev.medlink.components.SectionTitle
import com.joaquindev.medlink.components.SessionAppBar
import com.joaquindev.medlink.components.SessionBox
import com.joaquindev.medlink.components.SessionButton
import com.joaquindev.medlink.components.SpaceH

@Composable
fun RegisterView(navController: NavController) {
    Scaffold(
        topBar = {
            SessionAppBar(
                title = "Registrate",
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
            RegisterViewContent(navController)
        }
    }
}

@Composable
fun RegisterViewContent(navController: NavController) {
    val scrollState = rememberScrollState() // Variable para controlar el scroll de la columna
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp)
            .verticalScroll(scrollState) // Agregamos el scroll vertical a la columna
    ) {
        var name by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        SectionTitle(
            title = "¡Bienvenido!",
            color = MaterialTheme.colorScheme.primary,
        )
        SectionParagraph("Registrate para acceder a todas nuestras funcionalidades")
        SpaceH(30.dp)
        CustomBlockTextFiled(
            title = "Nombre completo",
            color = Color.Black,
            value = name,
            onValueChange = { name = it },
            visualTransformation = VisualTransformation.None,
            keyboardType = KeyboardType.Text
        )
        SpaceH()
        CustomBlockTextFiled(
            title = "Correo electrónico",
            color = Color.Black,
            value = email,
            onValueChange = { email = it },
            visualTransformation = VisualTransformation.None,
            keyboardType = KeyboardType.Email
        )
        SpaceH()
        CustomBlockTextFiled(
            title = "Contraseña",
            color = Color.Black,
            value = password,
            onValueChange = { password = it },
            visualTransformation = PasswordVisualTransformation(),
            keyboardType = KeyboardType.Password
        )
        SpaceH(40.dp)
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Al crear tu cuenta aceptas nuestros términos de uso y nuestra Política de privacidad",
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
            SessionButton(
                "Registrarme",
                MaterialTheme.colorScheme.primary,
                textColor = MaterialTheme.colorScheme.onPrimary,
                onclick = { navController.navigate("Home") }
            )
            SpaceH(30.dp)
            SectionParagraph("O registrate con")
            SpaceH()
            SessionBox(
                onclick = { /* Sesión o registro con google*/ }
            )
            SpaceH(30.dp)
            SectionParagraph("¿Ya tienes una cuenta?")
            CustomTextButton(
                "Iniciar sesión",
                onClick = { navController.navigate("Login") }
            )
        }
    }
}