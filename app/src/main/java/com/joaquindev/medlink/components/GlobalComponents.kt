package com.joaquindev.medlink.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.joaquindev.medlink.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SessionAppBar(
    title: String,
    onclick: () -> Unit
) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.onPrimary,
            titleContentColor = MaterialTheme.colorScheme.primary
        ),
        title = {
            Text(title, maxLines = 1, overflow = TextOverflow.Ellipsis, fontSize = 30.sp)
        },
        navigationIcon = {
            IconButton( onClick =  onclick ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowLeft,
                    contentDescription = "Back Icon",
                    modifier = Modifier.size(35.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CrudTopAppBar(
    title: String,
    onclick: () -> Unit,
    onclickNotifications: () -> Unit,
    onclickSettings: () -> Unit,
) {
    TopAppBar(
        modifier = Modifier.padding(horizontal = 25.dp),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.onPrimary,
            titleContentColor = MaterialTheme.colorScheme.primary
        ),
        navigationIcon = {
            IconButton( onClick =  onclick ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowLeft,
                    contentDescription = "Back Icon",
                    modifier = Modifier.size(35.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        },
        title = {
            Text(text = title, color = MaterialTheme.colorScheme.primary)
//            Row(verticalAlignment = Alignment.CenterVertically) {
//                Column {
//
//                    Text(text = "John Doe")
//                }
//            }
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

@Composable
fun BottomNavAppBar(
    onClickHome: () -> Unit,
    onClickCalendar: () -> Unit,
    onClickAdd: () -> Unit,
    onClickNotifications: () -> Unit,
    onClickSettings: () -> Unit
) {
    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.onPrimary, // Asegura el color del contenedor
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 25.dp)
                .fillMaxWidth()
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(percent = 50)
                ),
            horizontalArrangement = Arrangement.SpaceAround, // Distribuye los iconos espaciadamente
            verticalAlignment = Alignment.CenterVertically


        ) {
            CustomIconButton(
                Icons.Filled.Home,
                "Home Icon",
                onclick = onClickHome,
                MaterialTheme.colorScheme.onPrimary
            )
            CustomIconButton(
                Icons.Filled.DateRange,
                "Calendar Icon",
                onclick = onClickCalendar,
                MaterialTheme.colorScheme.onPrimary
            )
            CustomIconButton(
                Icons.Filled.Add,
                "Add Icon",
                onclick = onClickAdd,
                MaterialTheme.colorScheme.onPrimary
            )
            CustomIconButton(
                Icons.Filled.Notifications,
                "Notifications Icon",
                onclick = onClickNotifications,
                MaterialTheme.colorScheme.onPrimary
            )
            CustomIconButton(
                Icons.Filled.Person,
                "Perfil Icon",
                onclick = onClickSettings,
                MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@Composable
fun SpaceH(size: Dp = 10.dp) {
    Spacer(modifier = Modifier.height(size))
}

@Composable
fun SpaceW(size: Dp = 10.dp) {
    Spacer(modifier = Modifier.width(size))
}

@Composable
fun SectionTitle(
    title: String,
    color: Color
) {
    Text(
        text = title,
        color = color,
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun SectionTitleOption(
    title: String,
    color: Color
) {

}

@Composable
fun SectionParagraph(
    text: String
) {
    Text(text = text, fontSize = 18.sp)
}

@Composable
fun CustomBlockTextFiled(
    title: String,
    color: Color,
    value: String,
    onValueChange: (String) -> Unit,
    visualTransformation: VisualTransformation,
    keyboardType: KeyboardType //= KeyboardType.Text
) {
    SectionTitle(
        title = title,
        color = color
    )
    SpaceH()
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        visualTransformation = visualTransformation,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
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
}

@Composable
fun SessionButton(
    text: String,
    color: Color,
    textColor: Color,
    onclick: () -> Unit
) {
    Button(
        onClick = onclick,
        colors = ButtonDefaults.buttonColors(containerColor = color),
        modifier = Modifier.width(200.dp),
//        shape = RoundedCornerShape(15.dp)
    ) {
        Text(text = text, fontSize = 25.sp, color = textColor)
    }
}

@Composable
fun SessionBox(
    onclick: () -> Unit
) {
    Box(
        modifier = Modifier
            .width(70.dp)
            .height(70.dp)
            .background(MaterialTheme.colorScheme.secondary, RoundedCornerShape(50.dp)),
        contentAlignment = Alignment.Center
    ) {
        IconButton(
            onClick = onclick,
            modifier = Modifier.align(Alignment.Center)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.iconsgoogle),
                contentDescription = "Login with google",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(40.dp)
            )
        }
    }
}

@Composable
fun BoxIconButton(
    icon: ImageVector,
    contentDescription: String? = "",
    onclick: () -> Unit
) {
    Box(
        modifier = Modifier
            .width(40.dp)
            .height(40.dp)
//            .background(MaterialTheme.colorScheme.secondary, RoundedCornerShape(50.dp)),
            .background(MaterialTheme.colorScheme.secondary, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        IconButton(
            onClick = onclick,
            modifier = Modifier.align(Alignment.Center)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = contentDescription,
                tint = Color.Black,
                modifier = Modifier.size(25.dp)
            )
        }
    }
}

@Composable
fun CustomIconButton(
    icon: ImageVector,
    contentDescription: String? = "",
    onclick: () -> Unit,
    color: Color
) {
    IconButton(
        onClick = onclick,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = color,
            modifier = Modifier.size(25.dp)
        )
    }
}

@Composable
fun CustomTextButton(
    text: String,
    onClick: () -> Unit,
) {
    TextButton(
        onClick = onClick,
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun CrudButton(
    text: String,
    color: Color,
    textColor: Color,
    onclick: () -> Unit
) {
    Button(
        onClick = onclick,
        colors = ButtonDefaults.buttonColors(containerColor = color),
        modifier = Modifier.width(170.dp),
//        shape = RoundedCornerShape(15.dp)
    ) {
        Text(text = text, fontSize = 25.sp, color = textColor)
    }
}

@Composable
fun DropdownIconOption( // Implementar el botón de dropdown

) {

}





