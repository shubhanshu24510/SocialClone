package com.shubhans.socialclone.feature_profile.presentation.profile

import com.shubhans.socialclone.core.domain.models.Post

sealed class ProfileEvent {
    data class LikePost(val postId: String): ProfileEvent()
    data class DeletePost(val post: Post): ProfileEvent()
    object DismissLogoutDialog: ProfileEvent()
    object ShowLogoutDialog: ProfileEvent()
    object Logout: ProfileEvent()
}
