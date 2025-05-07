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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
fun GeneralTopAppBar() {

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
fun SectionParagraph(
    text: String
) {
    Text(text = text, fontSize = 18.sp)
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










