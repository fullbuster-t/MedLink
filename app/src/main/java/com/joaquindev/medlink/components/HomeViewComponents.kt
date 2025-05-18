package com.joaquindev.medlink.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joaquindev.medlink.R
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopAppBar(
    onclickProfile: () -> Unit,
    onclickNotifications: () -> Unit,
    onclickSettings: () -> Unit
) {
    TopAppBar(
        modifier = Modifier.padding(horizontal = 25.dp),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White, // O el color que desees
            titleContentColor = Color.Black, // O el color que desees
            actionIconContentColor = Color.Black // O el color que desees
        ),
        navigationIcon = {
            IconButton( onClick = onclickProfile ) {
                Image(
                    painter = painterResource(id = R.drawable.profile), // Reemplaza con tu imagen
                    contentDescription = "User avatar",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape),
                )
            }
        },
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column {
                    Text(text = "¡Hola, bienvenido!", color = MaterialTheme.colorScheme.primary)
                    Text(text = "John Doe")
                }
            }
        },
        actions = {
            BoxIconButton(
                icon = Icons.Filled.Notifications,
                contentDescription = "Notifications icon",
                onclick = onclickNotifications
            )
            SpaceW()
            BoxIconButton(
                icon = Icons.Filled.Settings,
                contentDescription = "Settings icon",
                onclick = onclickSettings
            )
        }
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeekRow() {

    val currentDate = remember { LocalDate.now() }
    val firstDayOfWeek = remember(currentDate) {
        currentDate.with(DayOfWeek.MONDAY)
    }

    val daysOfWeek = remember {
        listOf(
            DayOfWeek.MONDAY,
            DayOfWeek.TUESDAY,
            DayOfWeek.WEDNESDAY,
            DayOfWeek.THURSDAY,
            DayOfWeek.FRIDAY,
            DayOfWeek.SATURDAY,
            DayOfWeek.SUNDAY,
        )
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        daysOfWeek.forEachIndexed { index, day ->

            val date = firstDayOfWeek.plusDays(index.toLong())
            val dayNumber = date.dayOfMonth
            val dayAbbreviated = day.getDisplayName(TextStyle.SHORT, Locale("es"))
                .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
            val isSelected = date == currentDate
            DayWeekItem(day = dayAbbreviated, number = dayNumber.toString(), isSelect = isSelected)
        }

//        DayWeekItem(day = "Lu", number = "9", isSelect = false)
//        DayWeekItem(day = "Ma", number = "10", isSelect = false)
//        DayWeekItem(day = "Mi", number = "11", isSelect = false)
//        DayWeekItem(day = "Ju", number = "12", isSelect = true)
//        DayWeekItem(day = "Vi", number = "13", isSelect = false)
//        DayWeekItem(day = "Sa", number = "14", isSelect = false)
//        DayWeekItem(day = "Do", number = "15", isSelect = false)
    }
}

@Composable
fun DayWeekItem(day: String, number: String, isSelect: Boolean) {
    val backgroundColor = if (isSelect) Color(0xFF2260FF) else Color(0xFFFFFFFF)
    val textColor = if (isSelect) Color(0xFFFFFFFF) else Color(0xFF000000)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(45.dp) // Ajusta el ancho según necesites
            .height(75.dp) // Ajusta la altura según necesites
            .background(backgroundColor, RoundedCornerShape(40.dp))
            .padding(vertical = 10.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = day,
            color = textColor,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = number,
            color = textColor,
            fontSize = 16.sp
        )
    }
}

@Composable
fun TreatmentsCardsRow() {

}

@Composable
fun TreatmentCard() {

}

