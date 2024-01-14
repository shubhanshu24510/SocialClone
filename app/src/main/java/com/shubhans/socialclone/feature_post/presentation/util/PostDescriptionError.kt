package com.shubhans.socialclone.feature_post.presentation.util

import com.shubhans.socialclone.core.util.Error

sealed class PostDescriptionError : Error() {
    object FieldEmpty: PostDescriptionError()
}
