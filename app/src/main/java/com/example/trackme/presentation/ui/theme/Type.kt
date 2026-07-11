package com.example.trackme.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.trackme.R

// Set of Material typography styles to start with
val BricolageGrotesqueFontFamily = FontFamily(
    Font(
        R.font.bricolage_grotesque
    )
)

val GoogleSansFontFamily = FontFamily(
    Font(
        R.font.google_sans
    )
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = GoogleSansFontFamily,
        fontSize = 16.sp
    ),
    titleLarge = TextStyle(
        fontFamily = BricolageGrotesqueFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
    ),
    bodySmall = TextStyle(
        fontFamily = GoogleSansFontFamily,
        fontSize = 12.sp
    ),
    titleSmall = TextStyle(
        fontFamily = BricolageGrotesqueFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
    )
)