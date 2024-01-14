package com.shubhans.socialclone.feature_profile.presentation.util

import com.shubhans.socialclone.core.util.Error

sealed class EditProfileError : Error() {
    object FieldEmpty: EditProfileError()
}
