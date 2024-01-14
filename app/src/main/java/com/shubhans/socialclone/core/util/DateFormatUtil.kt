package com.shubhans.socialclone.core.util

import java.text.SimpleDateFormat
import java.util.Locale

object DateFormatUtil {
    fun timestampToFormattedString(timestamp: Long, pattern: String): String {
        return SimpleDateFormat(pattern, Locale.getDefault()).run {
            format(timestamp)
        }
    }
}