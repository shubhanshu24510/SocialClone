package com.shubhans.socialclone.feature_auth.domain.models

import com.shubhans.socialclone.core.util.SimpleResource
import com.shubhans.socialclone.feature_auth.presentation.util.AuthError

data class RegisterResult(
    val emailError: AuthError? = null,
    val usernameError: AuthError? = null,
    val passwordError: AuthError? = null,
    val result: SimpleResource? = null
)
