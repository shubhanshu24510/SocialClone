package com.shubhans.socialclone.core.utils

import androidx.annotation.StringRes
import com.shubhans.socialclone.R

sealed class UiText{
    data class DynamicResourse(val value :String): UiText()
    data class StringResourse(@StringRes val id: Int): UiText()
    companion object{
        fun unKnownError(): UiText {
            return StringResourse(R.string.unknown_Error)
        }
    }
}
