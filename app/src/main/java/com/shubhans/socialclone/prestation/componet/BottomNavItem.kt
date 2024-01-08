package com.shubhans.socialclone.prestation.componet

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.shubhans.socialclone.ui.theme.HintGray
import com.shubhans.socialclone.ui.theme.Spacesmall

@Composable
@Throws(IllegalArgumentException::class)
fun RowScope.StandardBottomNavItem(
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    icon: ImageVector,
    contentDescription: String? = "",
    alertCount: Int? = null,
    selectedColour: Color = MaterialTheme.colors.primary,
    unSelectedColour: Color = HintGray,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    if (alertCount != null && alertCount < 0) {
        throw IllegalArgumentException("Alert count can't be negative.")
    }
    val lineLength = animateFloatAsState(
        targetValue = if (selected) 1f else 0f,
        animationSpec = tween(durationMillis = 300), label = ""
    )
    BottomNavigationItem(selected = selected,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        selectedContentColor = selectedColour,
        unselectedContentColor = unSelectedColour,
        icon = {
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(Spacesmall)
                .drawBehind {
                    if (lineLength.value > 0f) {
                        drawLine(
                            color = if (selected) {
                                selectedColour
                            } else {
                                unSelectedColour
                            },
                            start = Offset(size.width / 2f - 15.dp.toPx(), size.height),
                            end = Offset(size.width / 2f + 15.dp.toPx(), size.height),
                            strokeWidth = 2.dp.toPx(),
                            cap = StrokeCap.Round
                        )
                    }
                }) {
                Icon(
                    imageVector = icon,
                    contentDescription = contentDescription,
                    modifier = Modifier.align(Alignment.Center)
                )
                if (alertCount != null) {
                    val alertText = if (alertCount > 99) {
                        "99+"
                    } else {
                        alertCount.toString()
                    }
                    Text(
                        text = alertText,
                        color = MaterialTheme.colors.onPrimary,
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .offset(5.dp)
                            .size(13.dp)
                            .clip(CircleShape)
                            .aspectRatio(1f)
                            .background(MaterialTheme.colors.primary)

                    )
                }
            }
        })
}