package com.shubhans.socialclone.feature_post.presentation.main_feed

import com.shubhans.socialclone.core.domain.models.Post

sealed class MainFeedEvent {
    data class LikedPost(val postId: String): MainFeedEvent()
    data class DeletePost(val post: Post): MainFeedEvent()
}
