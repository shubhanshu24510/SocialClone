package com.shubhans.socialclone.auth.data.dto.request

data class CreateAccountRequest(
    val email: String,
    val userName: String,
    val password: String
)
