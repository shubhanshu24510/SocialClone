package com.shubhans.socialclone.core.data.dto.response

data class BasicAPiResponse<T>(
    val successful: Boolean,
    val message: String ?=null,
    val data:T? =null
)
