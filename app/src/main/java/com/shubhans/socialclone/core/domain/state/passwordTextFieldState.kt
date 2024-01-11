package com.shubhans.socialclone.core.domain.state

data class passwordTextFieldState(
    val text:String = "",
    val error:Error ?=null,
    val isPasswordVisible:Boolean =false
)
