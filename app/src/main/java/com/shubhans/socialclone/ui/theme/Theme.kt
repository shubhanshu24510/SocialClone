package com.shubhans.socialclone.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = GreenAccent,
    background = DarkGray,
    onBackground = TextWhite,
    onPrimary = DarkGray,
    surface = MediumGray,
    onSurface = Color.LightGray
)

@Composable
fun SocialCloneTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = DarkColorPalette,
        typography = Typography,
        shapes = shapes,
        content = content
    )
}