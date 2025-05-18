package com.joaquindev.medlink.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.joaquindev.medlink.components.CrudButton
import com.joaquindev.medlink.components.CrudTopAppBar
import com.joaquindev.medlink.components.CustomBlockTextFiled
import com.joaquindev.medlink.components.SpaceH

@Composable
fun UpdateTreatmentView(navController: NavController) {
    Scaffold(
        topBar = {
            CrudTopAppBar(
                "Editar tratamiento",
                onclick = { navController.popBackStack() },
                onclickNotifications = { /*navController.navigate("Notifications")*/ },
                onclickSettings = { navController.navigate("Settings") },
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.onPrimary)

        ) {
            UpdateTreatmentViewContent(navController)
        }
    }
}

@Composable
fun UpdateTreatmentViewContent(navController: NavController) {
    val scrollState = rememberScrollState() // Variable para controlar el scroll de la columna
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp)
            .verticalScroll(scrollState) // Agregamos el scroll vertical a la columna
    ) {
        var nameTreatment by remember { mutableStateOf("") }
        var startDate by remember { mutableStateOf("") }
        var endDate by remember { mutableStateOf("") }
        var status by remember { mutableStateOf("") }
        var notes by remember { mutableStateOf("") }

        // Formulario Actualizar Tratamiento
        CustomBlockTextFiled(
            title = "Diagnostico",
            color = Color.Black,
            value = nameTreatment,
            onValueChange = { nameTreatment = it },
            visualTransformation = VisualTransformation.None,
            keyboardType = KeyboardType.Text
        )
        SpaceH()
        CustomBlockTextFiled(
            title = "Fecha de inicio",
            color = Color.Black,
            value = startDate,
            onValueChange = { startDate = it },
            visualTransformation = VisualTransformation.None,
            keyboardType = KeyboardType.Text
        )
        SpaceH()
        CustomBlockTextFiled(
            title = "Fecha de finalización",
            color = Color.Black,
            value = endDate,
            onValueChange = { endDate = it },
            visualTransformation = VisualTransformation.None,
            keyboardType = KeyboardType.Text
        )
        SpaceH()
        CustomBlockTextFiled(
            title = "Estatus",
            color = Color.Black,
            value = status,
            onValueChange = { status = it },
            visualTransformation = VisualTransformation.None,
            keyboardType = KeyboardType.Text
        )
        SpaceH()
        CustomBlockTextFiled(
            title = "Notas del tratamiento",
            color = Color.Black,
            value = notes,
            onValueChange = { notes = it },
            visualTransformation = VisualTransformation.None,
            keyboardType = KeyboardType.Text
        )
        SpaceH(40.dp)
        Row(
            horizontalArrangement = Arrangement.Absolute.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            CrudButton(
                "Actualizar",
                MaterialTheme.colorScheme.primary,
                textColor = MaterialTheme.colorScheme.onPrimary,
                onclick = { /*  */ }
            )
            CrudButton(
                "Cancelar",
                MaterialTheme.colorScheme.primary,
                textColor = MaterialTheme.colorScheme.onPrimary,
                onclick = { navController.popBackStack() }
            )
        }





    }
}

