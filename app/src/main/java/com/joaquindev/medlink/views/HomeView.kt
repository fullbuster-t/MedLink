package com.joaquindev.medlink.views

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.joaquindev.medlink.R
import com.joaquindev.medlink.components.BoxIconButton
import com.joaquindev.medlink.components.HomeTopAppBar
import com.joaquindev.medlink.components.SectionTitle
import com.joaquindev.medlink.components.SessionAppBar
import com.joaquindev.medlink.components.SpaceH
import com.joaquindev.medlink.components.SpaceW
import com.joaquindev.medlink.components.WeekRow

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController) {
    Scaffold(
        topBar = {
            HomeTopAppBar()
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.onPrimary)

        ) {
            SpaceH(20.dp)
            HomeViewContent(navController)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeViewContent(navController: NavController) {
    val scrollState = rememberScrollState() // Variable para controlar el scroll de la columna
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(scrollState) // Agregamos el scroll vertical a la columna
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.secondary)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(25.dp)
            ) {
                SectionTitle(
                    title = "Programados para hoy",
                    color = Color.Black,
                )
                SpaceH()
                WeekRow()
                Card(
                    modifier = Modifier.background(MaterialTheme.colorScheme.onPrimary)
                ) {

                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.onPrimary)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(25.dp)
            ) {
                SectionTitle(
                    title = "Tu calendario semanal",
                    color = Color.Black,
                )
                SpaceH()

            }
        }
    }
}