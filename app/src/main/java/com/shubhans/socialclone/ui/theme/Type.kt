package com.shubhans.socialclone.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.shubhans.socialclone.R

val quicksand = FontFamily(
    Font(R.font.quicksand_light, FontWeight.Light),
    Font(R.font.quicksand_regular, FontWeight.Normal),
    Font(R.font.quicksand_medium, FontWeight.Medium),
    Font(R.font.quicksand_semibold, FontWeight.SemiBold),
    Font(R.font.quicksand_bold, FontWeight.Bold),
)

val Typography = Typography(
    h1 = TextStyle(
        fontFamily = quicksand,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = TextWhite
    ),
    h2 = TextStyle(
        fontFamily = quicksand,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        color = TextWhite
    ),
    h3 = TextStyle(
        fontFamily = quicksand,
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp,
        color = TextWhite
    ),
    h4 = TextStyle(
        fontFamily = quicksand,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        color = TextWhite
    )
)
