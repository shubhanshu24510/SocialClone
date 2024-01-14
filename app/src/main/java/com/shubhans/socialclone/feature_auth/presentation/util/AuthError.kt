package com.shubhans.socialclone.feature_auth.presentation.util

import com.shubhans.socialclone.core.util.Error

sealed class AuthError : Error() {
    object FieldEmpty : AuthError()
    object InputTooShort : AuthError()
    object InvalidEmail: AuthError()
    object InvalidPassword : AuthError()
}
