package com.shubhans.socialclone.auth.domain.model

sealed class AuthError:Error(){
    object FieldEmpty:AuthError()
    object InputTooShort:AuthError()
    object InvalidEmail :AuthError()
    object InvalidPassword :AuthError()
}

