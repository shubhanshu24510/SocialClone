package com.shubhans.socialclone.core.domain.states

import com.shubhans.socialclone.core.util.Error

data class PasswordTextFieldState(
    val text: String = "",
    val error: Error? = null,
    val isPasswordVisible: Boolean = false
)
