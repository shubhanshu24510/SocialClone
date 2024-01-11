package com.shubhans.socialclone.core.utils

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

@Composable
fun UiText.asString(): String {
    return when (this) {
        is UiText.DynamicResourse -> this.value
        is UiText.StringResourse -> stringResource(id = this.id)
    }
}

fun UiText.asString(context: Context): String {
    return when (this) {
        is UiText.DynamicResourse -> this.value
        is UiText.StringResourse -> context.getString(this.id)
    }
}
