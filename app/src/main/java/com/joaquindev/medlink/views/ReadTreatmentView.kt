package com.joaquindev.medlink.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.joaquindev.medlink.R
import com.joaquindev.medlink.components.CrudTopAppBar
import com.joaquindev.medlink.components.CustomIconButton
import com.joaquindev.medlink.components.MedicamentText
import com.joaquindev.medlink.components.SectionTitle
import com.joaquindev.medlink.components.SectionTitleOption
import com.joaquindev.medlink.components.SpaceH
import com.joaquindev.medlink.components.SpaceW

@Composable
fun ReadTtreatmentView(navController: NavController) {
    Scaffold(
        topBar = {
            CrudTopAppBar(
                "Tratamiento",
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
            ReadTreatmentViewContent(navController)
        }
    }
}

@Composable
fun ReadTreatmentViewContent(navController: NavController) {
    val scrollState = rememberScrollState() // Variable para controlar el scroll de la columna
    var expandedTreatment by remember { mutableStateOf(false) }
    var expandedMedicine by remember { mutableStateOf(false) }
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp)
            .verticalScroll(scrollState) // Agregamos el scroll vertical a la columna
    ) {
        Row(
            horizontalArrangement = Arrangement.Absolute.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                modifier = Modifier.width(250.dp),
                text = "Lupus Nefritis Clase Mixta",
                color = Color.Black,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Box{
                CustomIconButton(
                    Icons.Filled.MoreVert,
                    contentDescription = "Botón de opciones",
                    onclick = { expandedTreatment = true },
                    Color.Black,
                )
                DropdownMenu(
                    expanded = expandedTreatment,
                    onDismissRequest = { expandedTreatment = false },
                    modifier = Modifier
                        .background(
                            color = MaterialTheme.colorScheme.onSecondary.copy(alpha = 0.95f),
                            shape = RoundedCornerShape(10.dp)
                        )
                ) {
                    DropdownMenuItem(
                        text = { Text("Editar tratamiento", color = Color.Black, fontWeight = FontWeight.Bold) },
                        onClick = {
                            expandedTreatment = false
                            navController.navigate("UpdateTreatment")
                        },
                        leadingIcon = {
                            Icon(Icons.Filled.Edit, contentDescription = "Editar", tint = Color.Black)
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Eliminar tratamiento", color = Color.Red, fontWeight = FontWeight.Bold) },
                        onClick = {
                            expandedTreatment = false
//                            projectVM.deleteProject(idDoc) {
//                                navController.popBackStack()
//                                Toast.makeText(context, "Proyecto eliminado", Toast.LENGTH_SHORT).show()
//                            }
                        },
                        leadingIcon = {
                            Icon(Icons.Filled.Delete, contentDescription = "Eliminar", tint = Color.Red)
                        }
                    )
                }
            }

        }
        SpaceH()
        Box(
            modifier = Modifier.background(
                color = MaterialTheme.colorScheme.secondary,
                shape = RoundedCornerShape(percent = 50)
            ),
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 25.dp, vertical = 10.dp),
                text = "04-05-2025   ->   04-06-2025", color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold
            )
        }
        SpaceH()
        Box(
            modifier = Modifier.background(
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(percent = 50)
            ),
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 25.dp, vertical = 10.dp),
                text = "En curso", color = MaterialTheme.colorScheme.onPrimary, fontWeight = FontWeight.Bold
            )
        }
        SpaceH(20.dp)
        Text("Notas referentes a el diagnostico o la enfermedad", textAlign = TextAlign.Center)
        SpaceH(20.dp)
        SectionTitle(
            "Medicamentos asignados",
            MaterialTheme.colorScheme.primary
        )
        SpaceH()

        Card(
            modifier = Modifier
                .fillMaxWidth()
//                .height(230.dp)
                .clickable { /**/ },
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondary
            )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth().padding(10.dp)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.medicament_icon_vector),
                    contentDescription = "Medicament image",
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape),
                )
                SpaceW()
                Column(

                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        MedicamentText(
                            "Prednisona 5mg",
                            Color.Black,
                            FontWeight.Bold
                        )
                        Box{
                            CustomIconButton(
                                Icons.Filled.MoreVert,
                                contentDescription = "Botón de opciones",
                                onclick = { expandedMedicine = true },
                                Color.Black,
                            )
                            DropdownMenu(
                                expanded = expandedMedicine,
                                onDismissRequest = { expandedMedicine = false },
                                modifier = Modifier
                                    .background(
                                        color = MaterialTheme.colorScheme.onSecondary.copy(alpha = 0.95f),
                                        shape = RoundedCornerShape(10.dp)
                                    )
                            ) {
                                DropdownMenuItem(
                                    text = { Text("Editar medicamento", color = Color.Black, fontWeight = FontWeight.Bold) },
                                    onClick = {
                                        expandedMedicine = false
                                        /*navController.navigate("UpdateTreatment")*/
                                    },
                                    leadingIcon = {
                                        Icon(Icons.Filled.Edit, contentDescription = "Editar", tint = Color.Black)
                                    }
                                )
                                DropdownMenuItem(
                                    text = { Text("Eliminar medicamento", color = Color.Red, fontWeight = FontWeight.Bold) },
                                    onClick = {
                                        expandedMedicine = false
//                            projectVM.deleteProject(idDoc) {
//                                navController.popBackStack()
//                                Toast.makeText(context, "Proyecto eliminado", Toast.LENGTH_SHORT).show()
//                            }
                                    },
                                    leadingIcon = {
                                        Icon(Icons.Filled.Delete, contentDescription = "Eliminar", tint = Color.Red)
                                    }
                                )
                            }
                        }
                    }
                    MedicamentText(
                        "1 tableta",
                        Color.Black,
                        FontWeight.Normal
                    )
                    MedicamentText(
                        "Cada 8 horas por 7 días",
                        MaterialTheme.colorScheme.primary,
                        FontWeight.Bold
                    )
                    MedicamentText(
                        "Vía de administración: oral",
                        Color.Black,
                        FontWeight.Normal
                    )
                }
            }
        }
    }
}








