package com.shubhans.socialclone.feature_post.presentation.util

import com.shubhans.socialclone.core.util.Error

sealed class CommentError : Error() {
    object FieldEmpty: CommentError()
}
