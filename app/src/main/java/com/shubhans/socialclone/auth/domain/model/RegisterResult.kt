package com.shubhans.socialclone.auth.domain.model

import com.shubhans.socialclone.core.utils.SimpleResourse

data class registerResult(
    val emailError:AuthError ?=null,
    val userNameError:AuthError?=null,
    val passwordError:AuthError ?=null,
    val result: SimpleResourse?=null
)
