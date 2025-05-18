package com.joaquindev.medlink.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

@Composable
fun MedicamentText (
    text: String,
    color: Color,
    fontWeight: FontWeight,

) {
    Text(text = text, color = color, fontWeight = fontWeight)
}